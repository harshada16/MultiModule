package com.ak.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ak.model.Question;
import com.ak.service.QuestionService;



@RestController
@RequestMapping("api")
public class QuestionController_Harshada {
	@Autowired
	QuestionService questionService;
	
	@RequestMapping("test")
	public ResponseEntity<String> test()
	{
		return new ResponseEntity<String>("Test", HttpStatus.CREATED);
	}
	@GetMapping(value = "/getQuestionById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> getUserById(@PathVariable("id") int id) {
		
		Question question = questionService.findById(id);

		if (question == null) {
			return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

	@PostMapping(value = "/saveQuestion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveQuestion(@RequestBody Question question, UriComponentsBuilder ucBuilder) {
		Serializable id=null;
		
		HttpHeaders headers = new HttpHeaders();
		
		id=questionService.saveQuestion(question);
			
		if(id!=null)
		
			return new ResponseEntity<String>("Question added in db successfully", HttpStatus.CREATED);
		else
			
			return new ResponseEntity<String>("Question not added in db successfully", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/getByQuestion/{question}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> getByQuestion(@PathVariable("question") String question) 
		{
		    List<Question> q = questionService.getByQuestion(question);
		    	if(q.isEmpty())
		    	{
		            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
		    	}
				return new ResponseEntity(q,HttpStatus.OK);
		}
	
	
	

	@GetMapping(value = "/showAllQuestion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> showAllQuestion() 
	{
		    List<Question> question = questionService.showAllQuestion();
		    	if(question.isEmpty())
		    	{
		            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
	
		    	}
				return new ResponseEntity(question,HttpStatus.OK);
			
	}
	
	
	
	@DeleteMapping(value = "/deletequestionbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(HttpStatus.OK)
	 public ResponseEntity<String> deletequestionbyid(@PathVariable int id) {
		questionService.deletequestionbyid(id);
		 return new ResponseEntity<String>("Question deleted successfully",HttpStatus.CREATED);
		 
	  }
	
	
	 @PutMapping(value = "/updateQuestion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Question> updateQuestion(@PathVariable(value = "id") int id, @RequestBody Question question){
	        return new ResponseEntity<Question>(questionService.updateQuestion(id, question), HttpStatus.OK);
	    }
	
	 
	 
}
