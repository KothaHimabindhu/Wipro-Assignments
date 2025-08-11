package com.wipro.bindhu.quiz.service;

import java.util.List;

import com.wipro.bindhu.quiz.entity.Question;

public interface QuestionService {
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
}