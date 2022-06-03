package com.example.demo.service.jpa.Question;

import com.example.demo.entity.jpa.Question.QuestionBoard;
import com.example.demo.repository.jpa.Question.QuestionBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuestionBoardServiceImpl implements QuestionBoardService {

    @Autowired
    QuestionBoardRepository repository;

    @Override
    public void register(QuestionBoard board) {
        repository.save(board);
    }

    @Override
    public List<QuestionBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public QuestionBoard read(Integer boardNo) {
        Optional<QuestionBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            QuestionBoard questionBoard = maybeReadBoard.get();
            questionBoard.increaseViewCnt();
            repository.save(questionBoard);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void modify(QuestionBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}