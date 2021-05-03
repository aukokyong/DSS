package com.dss.service;

import java.util.List;

import com.dss.model.Actor;
import com.dss.repository.actors.ActorRepository;
import com.dss.repository.actors.ActorRepositoryImpl;

public class ActorsServiceImpl implements ActorsService {
	
	ActorRepository actorsRepo = null;
	public ActorsServiceImpl() {
		System.out.println("ActorsService instantiated ....");
		actorsRepo = new ActorRepositoryImpl();
	}

	@Override
	public List getActors() {
		return actorsRepo.getActors();
	}

	@Override
	public int insertActor(Actor actor) {
		return actorsRepo.insertActor(actor);
	}

	@Override
	public int updateActor(Actor actor) {
		return actorsRepo.editActor(actor);
	}

	@Override
	public int delActor(Actor actor) {
		return actorsRepo.deleteActor(actor);
	}

	@Override
	public Actor getActor(int actorId) {
		return actorsRepo.getActor(actorId);
	}

}
