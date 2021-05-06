package com.dss.controller;
import com.dss.model.Actor;
import com.dss.repository.ActorRepository;
import com.dss.util.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
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
        try {
            Optional<Actor> optionalActor = actorRepository.findById(actorId);
            Actor actor = optionalActor.get();
            Colors.pc(actor);
            return actor;
        }catch(NoSuchElementException exception){
            System.out.println("Actor does not exist");
            return null;
        }
    }

    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor){
        //Ensure no duplicate entry when creating
        Colors.pc("Checking"+actor);
        List<Actor> actors = findActorsByFirstName(actor.getFirstName());
        boolean existingActor = false;
        long actorId = 0;
        if(actors != null) {
            if (actors.size() != 0) {
                for (int i = 0; i < actors.size(); i++) {
                    if (actor.getLastName().equals(actors.get(i).getLastName())) {
                        existingActor = true;
                        actorId = actors.get(i).getActorId();
                    }
                }
            }
        }

        //When an Actor has already been added, Attempts an update instead
        Actor actorReturned = null;
        if(!existingActor) {
            Colors.pc("Inserting " + actor);
            actorReturned = actorRepository.save(actor);
            Colors.pc("Inserted " + actor);
        }else{
            Colors.pc("Actor already exists, Updating " + actor);
            actorReturned = updateActor(actorId,actor);
            Colors.pc("Updated " + actor);
        }
        return actorReturned;
    }

    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable(value="id") long actorId, @RequestBody Actor actor){
        //Malformed Body Try/Catch
        try {
            Optional<Actor> optionalActor = actorRepository.findById(actorId);
            Actor actorFromDB = optionalActor.get();
            actorFromDB.setFirstName(actor.getFirstName());
            actorFromDB.setLastName(actor.getLastName());
            actorFromDB.setGender(actor.getGender());
            //In event an older movie/film is added
            //An Actor should not be able to age backwards
            if(actorFromDB.getAge() < actor.getAge())
                actorFromDB.setAge(actor.getAge());

            Colors.pc("Updating " + actor);
            Actor actorReturned = actorRepository.save(actorFromDB);
            Colors.pc("Updated " + actor);

            return actorReturned;
        }catch(NoSuchElementException exception){
            System.out.print("Unable to find Actor");
            return null;
        }
    }

    @DeleteMapping("/actor/{id}")
    public boolean deleteActor(@PathVariable(value="id")long actorId){
        Colors.pc("Checking "+actorId);
        Actor existingActor = findActorById(actorId);

        //Delete only when actor exists
        if(existingActor != null) {
            actorRepository.deleteById(actorId);
            Colors.pc("Deleted " + actorId);
            return true;
        }else{
            Colors.pc("Actor does not exist");
            return false;
        }
    }

    @GetMapping("/actor/name/{first_name}")
    public List<Actor> findActorsByFirstName(@PathVariable(value="first_name")String firstName){
        List<Actor> actors = null;

        try {
            Optional<List<Actor>> optionalActor = actorRepository.findActorsByFirstName(firstName);
            actors = optionalActor.get();
            actors.forEach(Colors::pc);
            return actors;
        }catch(NoSuchElementException exception){
            System.out.println("Actor does not exist");
            return null;
        }

    }





}
