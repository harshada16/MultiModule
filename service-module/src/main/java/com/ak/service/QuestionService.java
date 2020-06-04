package com.ak.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak.dao.QuestionDao;
import com.ak.model.Question;

@Transactional
@Service
public class QuestionService {
	
	@Autowired 
	QuestionDao questionDao;

	public Question findById(int id) {
		// TODO Auto-generated method stub
		return questionDao.findById(id);
	}

	
	public Serializable saveQuestion(Question question) {
		return questionDao.saveQuestion(question);
	}

	
	public List<Question> getByQuestion(String question) {
		return questionDao.getByQuestion(question);
	}

	

	
	public List<Question> showAllQuestion() {
		// TODO Auto-generated method stub
		return questionDao.showAllQuestion();
	}

	public Question updateQuestion(int id, Question question) {
		 if (questionDao.findById(id) != null){
			 Question qOld = questionDao.findById(id);

			 qOld.setQuestionText(question.getQuestionText());
	           

			 Question updatedQ = questionDao.updateQuestion(qOld);

	            return updatedQ;
	        }else{
	            return null;
	        }
	}

	

	
	public void deletequestionbyid(int id) {
		questionDao.deleteById(id);
		
	}

}
