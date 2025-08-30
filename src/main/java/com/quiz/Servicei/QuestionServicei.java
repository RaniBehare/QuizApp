package com.quiz.Servicei;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.Model.Question;

public interface QuestionServicei {

	public ResponseEntity<String> addQuestion(Question question);
	
	public ResponseEntity<List<Question>> getAllQuestions();

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category);

	public ResponseEntity<String> deleteQuestion(Integer id);


	

}
