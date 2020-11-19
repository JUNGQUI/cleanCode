package com.jklee.cleancode.qna.service;

import com.jklee.cleancode.qna.entity.DeleteHistory;
import com.jklee.cleancode.qna.repository.DeleteHistoryRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("deleteHistoryService")
public class DeleteHistoryService {
	@Resource(name = "deleteHistoryRepository")
	private DeleteHistoryRepository deleteHistoryRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveAll(List<DeleteHistory> deleteHistories) {
		deleteHistoryRepository.saveAll(deleteHistories);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(DeleteHistory deleteHistory) {
		deleteHistoryRepository.save(deleteHistory);
	}
}