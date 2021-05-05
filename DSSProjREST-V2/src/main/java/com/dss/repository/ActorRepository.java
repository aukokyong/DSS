package com.dss.repository;

import com.dss.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    public abstract List<Actor> findActorsByFirstName(String firstName);

}
