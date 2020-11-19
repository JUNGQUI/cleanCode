package com.jklee.cleancode.qna.repository;

import com.jklee.cleancode.qna.entity.Question;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	List<Question> findByDeletedFalse();

	Optional<Question> findByIdAndDeletedFalse(Long id);
}
