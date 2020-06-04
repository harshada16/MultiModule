package com.ak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questions_tbl")
public class Question {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column
	String QuestionText;
	@Column
	String option1;
	@Column
	String option2;
	@Column
	String option3;
	@Column
	String option4;
	@Column
	String option5;
	@Column
	String correctOption;
	String Explaination;
	
	
	
	public Question(String questionText, String option1, String option2, String option3, String option4, String option5,
			String correctOption, String explaination) {
		super();
		QuestionText = questionText;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.option5 = option5;
		this.correctOption = correctOption;
		Explaination = explaination;
	}







	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}



	



	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getQuestionText() {
		return QuestionText;
	}



	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}



	public String getOption1() {
		return option1;
	}



	public void setOption1(String option1) {
		this.option1 = option1;
	}



	public String getOption2() {
		return option2;
	}



	public void setOption2(String option2) {
		this.option2 = option2;
	}



	public String getOption3() {
		return option3;
	}



	public void setOption3(String option3) {
		this.option3 = option3;
	}



	public String getOption4() {
		return option4;
	}



	public void setOption4(String option4) {
		this.option4 = option4;
	}



	public String getOption5() {
		return option5;
	}



	public void setOption5(String option5) {
		this.option5 = option5;
	}



	public String getCorrectOption() {
		return correctOption;
	}



	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}



	public String getExplaination() {
		return Explaination;
	}



	public void setExplaination(String explaination) {
		Explaination = explaination;
	}







	@Override
	public String toString() {
		return "Question [id=" + id + ", QuestionText=" + QuestionText + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", option5=" + option5 + ", correctOption="
				+ correctOption + ", Explaination=" + Explaination + "]";
	}



	
	
	
	

}
