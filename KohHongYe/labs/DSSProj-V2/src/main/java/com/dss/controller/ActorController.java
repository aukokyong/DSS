package com.dss.controller;
import com.dss.model.Actor;
import com.dss.repository.ActorRepository;
import com.dss.util.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ActorController {
    @Autowired
    ActorRepository actorRepository;
    @GetMapping("/actors")
    public List<Actor> getAllActors(){
        List<Actor> actorsList = actorRepository.findAll();
        actorsList.forEach(Colors::pc);
        return actorsList;
    }

    @GetMapping("/actor/{id}")
    public Actor findActorById(@PathVariable(value="id")long actorId){
        Optional<Actor> optionalActor = actorRepository.findById(actorId);
        Actor actor = optionalActor.get();
        Colors.pc(actor);
        return actor;
    }

    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor){
        Colors.pc("Inserting "+ actor);
        Actor ActorReturned = actorRepository.save(actor);
        Colors.pc("Inserted " +actor);

        return ActorReturned;
    }

    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable(value="id") long actorId, @RequestBody Actor actor){
        Optional<Actor> optionalActor = actorRepository.findById(actorId);
        Actor actorFromDB = optionalActor.get();
        actorFromDB.setFirstName(actor.getFirstName());
        actorFromDB.setLastName(actor.getLastName());
        actorFromDB.setGender(actor.getGender());
        actorFromDB.setAge(actor.getAge());
        Colors.pc("Updating "+ actor);
        Actor actorReturned = actorRepository.save(actorFromDB);
        Colors.pc("Updated " +actor);
        return actorReturned;
    }

    @DeleteMapping("/actor/{id}")
    public boolean deleteActor(@PathVariable(value="id")long actorId){
        actorRepository.deleteById(actorId);
        Colors.pc("Deleted "+actorId);
        return true;
    }

    @GetMapping("/actor/name/{first_name}")
    public List<Actor> findActorsByFirstName(@PathVariable(value="first_name")String firstName){
        List<Actor> actors = actorRepository.findActorsByFirstName(firstName);
        actors.forEach(Colors::pc);
        return actors;
    }



}
