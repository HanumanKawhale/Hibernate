package com.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	@Id
	private int answer_Id;
	
	@ManyToOne
	private Question question;

	private String answer;
	public int getAnswer_Id() {
		return answer_Id;
	}
	public void setAnswer_Id(int answer_Id) {
		this.answer_Id = answer_Id;
	}
	

	public Answer(int answer_Id, String answer) {
		super();
		this.answer_Id = answer_Id;
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [answer_Id=" + answer_Id + ", answer=" + answer + "]";
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String string) {
		this.answer = string;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
