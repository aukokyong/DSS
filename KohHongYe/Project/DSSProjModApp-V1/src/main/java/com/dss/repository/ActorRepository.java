package com.dss.repository;

import java.util.List;

import com.dss.model.Actor;


public interface ActorRepository {
	public abstract List getActors();
	public abstract Actor getActor(int actorId);
	public abstract List getActorByFirstName(String firstName);
	public abstract int insertActor(Actor actor);
	public abstract int editActor(Actor actor);
	public abstract int deleteActor(Actor actor);
	
}
