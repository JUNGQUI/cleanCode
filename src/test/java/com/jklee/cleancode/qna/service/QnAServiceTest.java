package com.jklee.cleancode.qna.service;

import com.jklee.cleancode.qna.entity.Answer;
import com.jklee.cleancode.qna.entity.Question;
import com.jklee.cleancode.qna.entity.User;
import com.jklee.cleancode.qna.exception.CannotDeleteException;
import com.jklee.cleancode.qna.repository.AnswerRepository;
import com.jklee.cleancode.qna.repository.QuestionRepository;
import com.jklee.cleancode.qna.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class QnAServiceTest {
	@Autowired private QnAService qnAService;
	@Autowired private UserRepository userRepository;
	@Autowired private QuestionRepository questionRepository;
	@Autowired private AnswerRepository answerRepository;

	private User user;
	private User differentUser;
	private Question question;
	private Question questionAnswerByDifferent;
	private List<Answer> answersByUser_1;
	private List<Answer> answersByUser_2;

	@BeforeEach
	@Rollback
	void init() {
		user = User.builder()
				.userId("jklee")
				.password("password")
				.name("정퀴")
				.email("ljk2518@gmail.com")
				.build();

		differentUser = User.builder()
				.userId("jung_queue")
				.password("password")
				.name("퀴정")
				.email("jungQueue@email.com")
				.build();

		answersByUser_1 = answerBuilder(user, question);
		answersByUser_2 = answerBuilder(user, questionAnswerByDifferent);

		question = Question.builder()
				.title("질문 제목")
				.writer(user)
				.contents("질문 내용")
				.deleted(false)
				.answers(new ArrayList<>())
				.build();

		questionAnswerByDifferent = Question.builder()
				.title("다른 사용자가 남긴 질문")
				.writer(differentUser)
				.contents("질문 내용")
				.deleted(false)
				.answers(new ArrayList<>())
				.build();

		answersByUser_1 = answerBuilder(user, question);
		answersByUser_2 = answerBuilder(user, questionAnswerByDifferent);

		user = userRepository.save(user);
		differentUser = userRepository.save(differentUser);

		question = questionRepository.save(question);
		questionAnswerByDifferent = questionRepository.save(questionAnswerByDifferent);

		for (Answer answer : answersByUser_1) {
			answer = answerRepository.save(answer);
			question.addAnswer(answer);
		}

		for (Answer answer : answersByUser_2) {
			answer = answerRepository.save(answer);
			questionAnswerByDifferent.addAnswer(answer);
		}
	}

	List<Answer> answerBuilder(User user, Question question) {
		List<Answer> answers = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			answers.add(
					Answer.builder()
							.contents("답변 내용 " + i)
							.deleted(false)
							.writer(user)
							.question(question)
							.build()
			);
		}

		return answers;
	}

	@Test
	void delete() {
		qnAService.delete(question, answersByUser_1);

		Assertions.assertTrue(question.isDeleted());

		for (Answer answer : answersByUser_1) {
			Assertions.assertTrue(answer.isDeleted());
		}
	}

	@Test
	void checkDeletePrivilege() throws CannotDeleteException {
		Assertions.assertThrows(
				CannotDeleteException.class,
				() -> qnAService.checkDeletePrivilege(question, differentUser)
		);

		Assertions.assertThrows(
				CannotDeleteException.class,
				() -> qnAService.checkDeletePrivilege(questionAnswerByDifferent, differentUser)
		);

		Assertions.assertEquals(question.getAnswers(), qnAService.checkDeletePrivilege(question, user));
	}
}