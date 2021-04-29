package com.dss.repository.util;

import java.util.ArrayList;

import com.dss.model.Actor;


public interface ActorsRepository {
	public abstract ArrayList getActors();
	public abstract int insertActor(Actor actor);
	public abstract int editActor(Actor actor);
	public abstract int deleteActor(Actor actor);
}
