package com.dss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dss.repository.util.MySQLConnectionUtil;
import com.dss.model.Actor;

public class ActorRepositoryImpl implements ActorRepository {

	@Override
	public List getActors() {
		List actors = new ArrayList();
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			// statement for executing a query
			Statement statement = connection.createStatement();
			// get the results
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ACTORS");
			while (resultSet.next()) {
				Actor actor = new Actor();
				actor.setActorId(resultSet.getInt(1));
				actor.setFirstName(resultSet.getString(2));
				actor.setLastName(resultSet.getString(3));
				actor.setGender(resultSet.getString(4).charAt(0));
				actor.setAge(resultSet.getInt(5));
				
				actors.add(actor);
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return actors;
	}

	@Override
	public int insertActor(Actor actor) {
		int success =0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();	
			String insertString = "INSERT INTO ACTORS (ACTOR_ID,FIRST_NAME,LAST_NAME,GENDER,AGE) VALUE(?,?,?,?,?)";
			
			// prepared statement for executing a query
			PreparedStatement statement = connection.prepareStatement(insertString);
			
			// Insert variables
			statement.setInt(1,actor.getActorId());
			statement.setString(2, actor.getFirstName());
			statement.setString(3, actor.getLastName());
			statement.setString(4, ""+actor.getGender());
			statement.setInt(5, actor.getAge());
			
			// Perform insert DML
			success = statement.executeUpdate();
			
			
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return success;
	}

	@Override
	public int editActor(Actor actor) {
		int success =0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();	
			String updateString = "UPDATE ACTORS SET ACTOR_ID = ?, FIRST_NAME = ? ,LAST_NAME = ?,GENDER = ?, AGE = ? WHERE ACTOR_ID = ?";
			
			// prepared statement for executing a query
			PreparedStatement statement = connection.prepareStatement(updateString);
			
			// Insert variables
			statement.setInt(1,actor.getActorId());
			statement.setString(2, actor.getFirstName());
			statement.setString(3, actor.getLastName());
			statement.setString(4, ""+actor.getGender());
			statement.setInt(5, actor.getAge());
			statement.setInt(6, actor.getActorId());
			
			// Perform insert DML
			success = statement.executeUpdate();
			
			
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return success;
	}

	@Override
	public int deleteActor(Actor actor) {
		int success =0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();	
			String delString = "DELETE FROM ACTORS WHERE ACTOR_ID = ?";
			
			// prepared statement for executing a query
			PreparedStatement statement = connection.prepareStatement(delString);
			
			// Insert variables
			statement.setInt(1,actor.getActorId());
			
			// Perform insert DML
			success = statement.executeUpdate();
			
			
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return success;
	}

	@Override
	public Actor getActor(int actorId) {
		Actor actor = new Actor();
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			String selString = "SELECT * FROM ACTORS WHERE ACTOR_ID = ?";
			// statement for executing a query
			PreparedStatement statement = connection.prepareStatement(selString);
			statement.setInt(1,actorId);
			// get the results
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				actor.setActorId(resultSet.getInt(1));
				actor.setFirstName(resultSet.getString(2));
				actor.setLastName(resultSet.getString(3));
				actor.setGender(resultSet.getString(4).charAt(0));
				actor.setAge(resultSet.getInt(5));
			}
			
			
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return actor;
	}
	
	public List getActorByFirstName(String firstName) {
		List actors = new ArrayList();
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			String selString = "SELECT * FROM ACTORS WHERE FIRST_NAME = ?";
			// statement for executing a query
			PreparedStatement statement = connection.prepareStatement(selString);
			statement.setString(1, firstName);
			// get the results
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Actor actor = new Actor();
				actor.setActorId(resultSet.getInt(1));
				actor.setFirstName(resultSet.getString(2));
				actor.setLastName(resultSet.getString(3));
				actor.setGender(resultSet.getString(4).charAt(0));
				actor.setAge(resultSet.getInt(5));
				actors.add(actor);
			}
			
			
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return actors;
			
		
	}

}
