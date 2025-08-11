package com.wipro.bindhu.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bindhu.quiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}