package com.jklee.cleancode.qna.service;

import com.jklee.cleancode.qna.entity.Answer;
import com.jklee.cleancode.qna.entity.ContentType;
import com.jklee.cleancode.qna.entity.DeleteHistory;
import com.jklee.cleancode.qna.entity.Question;
import com.jklee.cleancode.qna.entity.User;
import com.jklee.cleancode.qna.exception.CannotDeleteException;
import com.jklee.cleancode.qna.exception.NotFoundException;
import com.jklee.cleancode.qna.repository.AnswerRepository;
import com.jklee.cleancode.qna.repository.QuestionRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("qnaService")
public class QnAService {
	@Resource(name = "questionRepository")
	private QuestionRepository questionRepository;

	@Resource(name = "answerRepository")
	private AnswerRepository answerRepository;

	@Resource(name = "deleteHistoryService")
	private DeleteHistoryService deleteHistoryService;

	@Transactional(readOnly = true)
	public Question findQuestionById(Long id) {
		return questionRepository.findByIdAndDeletedFalse(id)
				.orElseThrow(NotFoundException::new);
	}

	@Transactional
	public void deleteQuestion(User loginUser, long questionId) throws CannotDeleteException {
		Question question = findQuestionById(questionId);
		List<Answer> answers = checkDeletePrivilege(question, loginUser);

		delete(question, answers);
	}

	@Transactional
	public void delete(Question question, List<Answer> answers) {
		List<DeleteHistory> deleteHistories = new ArrayList<>();

		question.setDeleted(true);
		deleteHistories.add(
				new DeleteHistory(
						ContentType.QUESTION,
						question.getId(),
						question.getWriter(),
						LocalDateTime.now())
		);

		for (Answer answer : answers) {
			answer.setDeleted(true);
			deleteHistories.add(
					new DeleteHistory(
							ContentType.ANSWER,
							answer.getId(),
							answer.getWriter(),
							LocalDateTime.now())
			);
		}

		deleteHistoryService.saveAll(deleteHistories);
	}

	public List<Answer> checkDeletePrivilege(Question question, User loginUser) throws CannotDeleteException {
		if (!question.isOwner(loginUser)) {
			throw new CannotDeleteException("질문을 삭제할 권한이 없습니다.");
		}

		List<Answer> answers = question.getAnswers();
		for (Answer answer : answers) {
			if (!answer.isOwner(loginUser)) {
				throw new CannotDeleteException("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
			}
		}

		return answers;
	}
}
