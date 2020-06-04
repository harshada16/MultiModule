package com.ak.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ak.model.Question;



@Repository
public class QuestionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Question findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Question employee = (Question) session.get(Question.class, id);
		return employee;
	}

	
	public Serializable saveQuestion(Question employee) {
		Session session =	sessionFactory.getCurrentSession();
		Serializable e = session.save(employee);
		return e;
	}

	
	public List<Question> getByQuestion(String question) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Question where QuestionText=:question");
		q.setParameter("question", question);
		List<Question> questionn = q.list();
		return questionn;
	}

	

	
	public List<Question> showAllQuestion() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Question");
		List<Question> question = q.list();
		return question;	
	}
	
	
	public Question updateQuestion(Question qOld) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(qOld);
		tx.commit();
        return qOld;
	}


	
	public void deleteById(int id) {
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 Question question = session.byId(Question.class).load(id);
	      session.delete(question);
	      transaction.commit(); 
		
	}

	

}
