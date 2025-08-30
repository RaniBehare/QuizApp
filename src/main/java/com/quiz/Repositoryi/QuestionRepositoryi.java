package com.quiz.Repositoryi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.Model.Question;

@Repository
public interface QuestionRepositoryi extends JpaRepository<Question, Integer>{

	public List<Question> findByCategory(String category);

	@Query(value="SELECT q FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ")
	public List<Question> findRandomQuestionsByCategory(String category, int numQ);
	
//	@Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT : numQ", nativeQuery = true)
//	public Optional<List<Question>> findRandomQuestionsByCategory(String category, int numQ);

}
    