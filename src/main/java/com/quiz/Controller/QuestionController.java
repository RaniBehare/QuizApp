package com.quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.Model.Question;
import com.quiz.Servicei.QuestionServicei;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionServicei questionServicei;
	
	@PostMapping("/add")
	public String addQuestion(@RequestBody Question question)
	{
		questionServicei.addQuestion(question);
		return "Data saved";

	}
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion()
	{
		return questionServicei.getAllQuestions() ;
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
	{
		return questionServicei.getQuestionsByCategory(category);
	}
	
	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable Integer id)
	{
		questionServicei.deleteQuestion(id);
		return "Question deleted successfully";
	}
	
	@PutMapping("/updateQuestion/{id}")
	public String updateQuestion(@PathVariable Integer id, @RequestBody Question question)
	{
		questionServicei.addQuestion(question);
		return "Question upated successfully";
	}
	
	
}
