package com.quiz.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.Model.Question;
import com.quiz.Repositoryi.QuestionRepositoryi;
import com.quiz.Servicei.QuestionServicei;

@Service
public class QuestionServiceImpl implements QuestionServicei{

	@Autowired
	QuestionRepositoryi questionRepositoryi;
	
	@Override
	public ResponseEntity<String> addQuestion(Question question) {
		
		try {
			questionRepositoryi.save(question);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		}catch (Exception e) {
			e.getStackTrace();
		}
		return new ResponseEntity<>("Unable to add", HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<List<Question>> getAllQuestions() {
		
		try {
			
			return new ResponseEntity<>(questionRepositoryi.findAll(), HttpStatus.OK);
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		
		try {
			
			return new ResponseEntity<>(questionRepositoryi.findByCategory(category), HttpStatus.OK);
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> deleteQuestion(Integer id) {
		
		try {
			questionRepositoryi.deleteById(id);
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}catch (Exception e) {
			e.getStackTrace();
		}
		return new ResponseEntity<>("Unable to delete", HttpStatus.BAD_REQUEST);
	}

	

}
