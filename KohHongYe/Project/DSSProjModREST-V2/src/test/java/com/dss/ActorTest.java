package com.dss;

import com.dss.controller.ActorController;
import com.dss.model.Actor;
import com.dss.repository.ActorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ActorTest {
	@Autowired
	static ActorController actorCtrl = null;

	@BeforeAll
	public ActorTest(){
		actorCtrl = new ActorController();
	}
	
	@Test
	public void testSuccessfulActorInsert() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		//Inserting new user
		assertEquals(1, actorCtrl.createActor(actor));
		actorCtrl.deleteActor();
	}
	
	@Test
	public void testFailedActorInsert() {
		Actor actor = new Actor(1,"Hong Best","Koh",'M',99);
		//Inserting a user with existing actorId (Key constraint)
		assertEquals(0, actorRepo.insertActor(actor));
	}
	
	@Test
	public void testSuccessfulActorDelete() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		actorRepo.insertActor(actor);

		//Deleting an existing user
		assertEquals(1, actorRepo.deleteActor(actor));
	}
	
	@Test
	public void testFailedActorDelete() {
		//Deleting an non-existent user
		Actor actor = new Actor(999,"Hong Best","Koh",'M',99);
		assertEquals(0, actorRepo.deleteActor(actor));
	}
	
	@Test
	public void testSuccessfulActorUpdate() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		actorRepo.insertActor(actor);

		//Updating an existing user
		actor.setFirstName("Not Hong");
		assertEquals(1, actorRepo.editActor(actor));
		actorRepo.deleteActor(actor);
	}
	
	@Test
	public void testFailedActorUpdate() {
		//Updating a non-existent user
		Actor actor = new Actor(99,"Hong Best","Koh",'M',99);
		assertEquals(0, actorRepo.editActor(actor));
	}
	
	@Test
	public void testRetrieveAllActors() {
		assertEquals(6, actorRepo.getActors().size());
	}
	
	@Test
	public void testAddNewFilmSuccessful() {
		String firstName ="Hong";
		String lastName = "Koh";
		int age = 66;
		char gender = 'M';

		//Checks if Actor already added
		assertEquals(0,actorRepo.getActorByFirstName(firstName).size());


		//Preps new actor id
		int actorId = actorRepo.getActors().size()+1;
		Actor actor = new Actor(actorId,firstName,lastName,gender,age);

		//Attempts to insert
		assertEquals(1,actorRepo.insertActor(actor));
		actorRepo.deleteActor(actor);
	}
	
	@Test
	public void testRemoveActor() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		actorRepo.insertActor(actor);

		//Search by First Name, Success if more than 1 is returned
		assertNotEquals(0,actorRepo.getActorByFirstName(actor.getFirstName()).size());
		List<Actor> actors = actorRepo.getActorByFirstName(actor.getFirstName());

		//Since we a deleting a particular person, First name may have duplicates
		//Check with Last Name
		assertTrue(actors.get(0).getLastName().equals(actor.getLastName()));

		//Attempts the delete
		assertEquals(1,actorRepo.deleteActor(actor));
		
	}
	
	
	
}
