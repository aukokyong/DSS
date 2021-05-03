import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dss.model.Actor;
import com.dss.repository.actors.ActorRepository;
import com.dss.repository.actors.ActorRepositoryImpl;

public class AppTest {
	static ActorRepository actorRepo = null;
	
	@BeforeAll
	public static void setup() {
		actorRepo = new ActorRepositoryImpl();
	}
	
	@Test
	public void testSuccessfulActorInsert() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		assertEquals(1, actorRepo.insertActor(actor));
		actorRepo.deleteActor(actor);
	}
	
	@Test
	public void testFailedActorInsert() {
		Actor actor = new Actor(1,"Hong Best","Koh",'M',99);
		assertEquals(0, actorRepo.insertActor(actor));
	}
	
	@Test
	public void testSuccessfulActorDelete() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		actorRepo.insertActor(actor);
		assertEquals(1, actorRepo.deleteActor(actor));
	}
	
	@Test
	public void testFailedActorDelete() {
		Actor actor = new Actor(999,"Hong Best","Koh",'M',99);
		assertEquals(0, actorRepo.deleteActor(actor));
	}
	
	@Test
	public void testSuccessfulActorUpdate() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		actorRepo.insertActor(actor);
		actor.setFirstName("Not Hong");
		assertEquals(1, actorRepo.editActor(actor));
		actorRepo.deleteActor(actor);
	}
	
	@Test
	public void testFailedActorUpdate() {
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
		assertEquals(null,actorRepo.getActorByFullName(firstName, lastName));
		int actorId = actorRepo.getActors().size();
		Actor actor = new Actor(actorId,firstName,lastName,gender,age);
		assertEquals(1,actorRepo.insertActor(actor));
		actorRepo.deleteActor(actor);
	}
	
	@Test
	public void testRemoveActor() {
		Actor actor = new Actor(7,"Hong","Koh",'M',30);
		actorRepo.insertActor(actor);
		assertNotNull(actorRepo.getActorByFullName(actor.getFirstName(), actor.getLastName()));		
		assertEquals(1,actorRepo.deleteActor(actor));
		
	}
	
	
	
}
