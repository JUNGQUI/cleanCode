package com.jklee.cleancode.qna.entity;

import com.jklee.cleancode.qna.exception.NotFoundException;
import com.jklee.cleancode.qna.exception.UnAuthorizedException;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder @Entity
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends AbstractEntity {
	@ManyToOne(optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	private User writer;

	@ManyToOne(optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
	private Question question;

	@Lob
	private String contents;

	@Builder.Default
	private boolean deleted = false;

	public Answer(User writer, Question question, String contents) {
		this(null, writer, question, contents);
	}

	public Answer(Long id, User writer, Question question, String contents) {
		super(id);

		if(writer == null) {
			throw new UnAuthorizedException();
		}

		if(question == null) {
			throw new NotFoundException();
		}

		this.writer = writer;
		this.question = question;
		this.contents = contents;
	}

	public Answer setDeleted(boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public boolean isOwner(User writer) {
		return this.writer.equals(writer);
	}

	public User getWriter() {
		return writer;
	}

	public String getContents() {
		return contents;
	}

	public void toQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + getId() + ", writer=" + writer + ", contents=" + contents + "]";
	}
}