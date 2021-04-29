package com.dss.model;

import java.io.Serializable;

public class Actor extends Object implements Serializable{
	private int actorId;
	private String firstName;
	private String lastName;
	private char gender;
	private int age;
	
	public Actor(int actorId,String firstName, String lastName,char gender, int age) {
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}
	
	public Actor() {
		
	}
	
	public int getActor_id() {
		return actorId;
	}
	public void setActor_id(int actor_id) {
		this.actorId = actor_id;
	}
	public String getFirst_name() {
		return firstName;
	}
	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}
	public String getLast_name() {
		return lastName;
	}
	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		String actorString;
		actorString = "\nActor Id : " + getActor_id();
		actorString += "\tFirst Name : " + getFirst_name();
		actorString += "\tLast Name : " + getLast_name();
		actorString += "\tGender : " + getGender();
		actorString += "\tAge : " + getAge() + "\n";
		return actorString;
	}
}
