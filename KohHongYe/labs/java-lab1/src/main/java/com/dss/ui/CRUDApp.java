package com.dss.ui;

import java.util.List;

import com.dss.model.Actor;
import com.dss.service.ActorsService;
import com.dss.service.ActorsServiceImpl;

public class CRUDApp {
	public static void main(String [] args) {
		//Retrieve Actors
		getActorsFromDB();
		
		//Successful Insert
		insertActorIntoDB(7,"Hong","Koh",'M',30);
		//Failed Insert
		insertActorIntoDB(7,"Another Hong","Koh",'M',99);

		//Retrieve Actor
		Actor actor = getActorFromDB(7);
		
		//Successful Update
		actor.setAge(66);
		updateActorToDB(actor);
		actor = getActorFromDB(7);


		//Successful Delete
		deleteActorFromDB(actor);
		//Failed Delete
		deleteActorFromDB(null);

	}

	private static Actor getActorFromDB(int actorId) {
		// creating the Actors service reference
		ActorsService actorsService = null;
		// instantiate the Actors service
		actorsService = new ActorsServiceImpl();
		Actor actor = actorsService.getActor(actorId);

		System.out.println(actor);
		return actor;
	}

	private static List getActorsFromDB() {
		// creating the Actors service reference
		ActorsService actorsService = null;
		// instantiate the Actors service
		actorsService = new ActorsServiceImpl();
		List actors = actorsService.getActors();

		System.out.println(actors);
		return actors;
	}

	private static void insertActorIntoDB(int actorId, String firstName, String lastName, char gender, int age) {
		// creating the Actors service reference
		ActorsService actorsService = null;
		// instantiate the Actors service
		actorsService = new ActorsServiceImpl();

		int success = 0;
		success = actorsService.insertActor(new Actor(actorId,firstName,lastName,gender,age));

		if(success==0)
			System.out.println("Insert Failed");
		else
			System.out.println("Insert Successful");
	}

	private static void deleteActorFromDB(Actor actor) {
		try {
			// creating the Actors service reference
			ActorsService actorsService = null;
			// instantiate the Actors service
			actorsService = new ActorsServiceImpl();

			int success = 0;
			success = actorsService.delActor(actor);

			if(success==0)
				System.out.println("Delete Failed");
			else
				System.out.println("Delete Successful");
		}catch(NullPointerException exception) {
			System.out.println("No such actor");
		}
	}

	private static void updateActorToDB(Actor actor) {
		try {
			// creating the Actors service reference
			ActorsService actorsService = null;
			// instantiate the Actors service
			actorsService = new ActorsServiceImpl();

			int success = 0;
			success = actorsService.updateActor(actor);

			if(success==0)
				System.out.println("Update Failed");
			else
				System.out.println("Update Successful");
		}catch(NullPointerException exception) {
			System.out.println("No such actor");
		}
	}
}
