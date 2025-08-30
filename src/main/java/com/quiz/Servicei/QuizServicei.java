package com.quiz.Servicei;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.Model.Question;
import com.quiz.Model.QuestionWrapper;
import com.quiz.Model.Response;

public interface QuizServicei {

	ResponseEntity<String> createQuiz(String category, int numQ, String title);

	ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

	ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);

}
