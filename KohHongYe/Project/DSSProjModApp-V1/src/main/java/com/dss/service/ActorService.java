package com.dss.service;

import java.util.ArrayList;
import java.util.List;

import com.dss.model.Actor;

public interface ActorService {

	public abstract List getActors();
	public abstract Actor getActor(int actorId);
	public abstract int insertActor(Actor actor);
	public abstract int updateActor(Actor actor);
	public abstract int delActor(Actor actor);
	
}
