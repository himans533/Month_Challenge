package com.ChallengeApp.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column(name ="challengeMonth")
	private String month;
	private String Decription;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDecription() {
		return Decription;
	}
	public void setDecription(String decription) {
		Decription = decription;
	}
	public Challenge(Long id, String month, String decription) {
		super();
		this.id = id;
		this.month = month;
		Decription = decription;
	}
	@Override
	public String toString() {
		return "Challenge [id=" + id + ", month=" + month + ", Decription=" + Decription + "]";
	}
	public Challenge() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
