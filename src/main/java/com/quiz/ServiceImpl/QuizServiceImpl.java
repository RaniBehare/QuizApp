package com.quiz.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.Model.Question;
import com.quiz.Model.QuestionWrapper;
import com.quiz.Model.Quiz;
import com.quiz.Model.Response;
import com.quiz.Repositoryi.QuestionRepositoryi;
import com.quiz.Repositoryi.QuizRepositoryI;
import com.quiz.Servicei.QuizServicei;

@Service
public class QuizServiceImpl implements QuizServicei{

	@Autowired
	QuizRepositoryI quizRepositoryi;
	
	@Autowired
	QuestionRepositoryi questionRepositoryi;

	@Override
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> question = questionRepositoryi.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		quizRepositoryi.save(quiz);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
		Optional<Quiz> quiz = quizRepositoryi.findById(id);
		List<Question> questionFromDb = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		
		for(Question q : questionFromDb)
		{
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizRepositoryi.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int i =0;
		int right = 0;
		for(Response response: responses)
		{
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			
			i++;
		}
		return new ResponseEntity<Integer>(right, HttpStatus.OK);
	}
	
	
}
