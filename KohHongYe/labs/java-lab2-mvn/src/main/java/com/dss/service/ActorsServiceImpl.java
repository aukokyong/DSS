package com.dss.service;

import java.util.List;

import com.dss.model.Actor;
import com.dss.repository.actors.ActorsRepository;
import com.dss.repository.actors.ActorsRepositoryImpl;

public class ActorsServiceImpl implements ActorsService {
	
	ActorsRepository actorsRepo = null;
	public ActorsServiceImpl() {
		System.out.println("ActorsService instantiated ....");
		actorsRepo = new ActorsRepositoryImpl();
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
