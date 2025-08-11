package com.example.quiz.service;

import com.example.quiz.entity.Question;
import com.example.quiz.exception.ResourceNotFoundException;
import com.example.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + id));
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question updated) {
        Question existing = getQuestionById(id);
        existing.setQuestionTitle(updated.getQuestionTitle());
        existing.setOption1(updated.getOption1());
        existing.setOption2(updated.getOption2());
        existing.setOption3(updated.getOption3());
        existing.setOption4(updated.getOption4());
        existing.setCorrectAnswer(updated.getCorrectAnswer());
        existing.setDifficulty(updated.getDifficulty());
        existing.setCategory(updated.getCategory());
        return questionRepository.save(existing);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question existing = getQuestionById(id);
        questionRepository.delete(existing);
    }
}