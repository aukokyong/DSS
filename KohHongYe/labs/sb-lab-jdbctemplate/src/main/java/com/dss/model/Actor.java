package com.dss.model;

import java.io.Serializable;

public class Actor extends Object implements Serializable{
	private long actorId;
	private String firstName;
	private String lastName;
	private char gender;
	private int age;
	
	public Actor(long actorId,String firstName, String lastName,char gender, int age) {
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}
	
	public Actor() {
		
	}
	
	public long getActorId() {
		return actorId;
	}
	public void setActorId(long actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		actorString = "\nActor Id : " + getActorId();
		actorString += "\tFirst Name : " + getFirstName();
		actorString += "\tLast Name : " + getLastName();
		actorString += "\tGender : " + getGender();
		actorString += "\tAge : " + getAge() + "\n";
		return actorString;
	}
}
