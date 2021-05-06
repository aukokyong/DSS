package com.dss.repository;

import java.util.List;
import java.util.Optional;

import com.dss.model.Actor;

public interface ActorJDBCRepository {

	List<Actor> findAll();

	Optional<Actor> findById(long prodcutId);

	int insert(Actor actor);

	int update(Actor actor);

	int deleteById(long actorId);

	int deleteAll();

}