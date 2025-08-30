package com.quiz.Repositoryi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.Model.Quiz;

@Repository
public interface QuizRepositoryI extends JpaRepository<Quiz, Integer>{

}
