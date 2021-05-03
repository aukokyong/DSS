import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dss.model.Actor;
import com.dss.repository.actors.ActorsRepository;
import com.dss.repository.actors.ActorsRepositoryImpl;

public class AppTest {
	static ActorsRepository actorRepo = null;
	
	@BeforeAll
	public static void setup() {
		actorRepo = new ActorsRepositoryImpl();
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
	
	
}
