package com.dss.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ACTORS")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long actorId;
    @Column(name="first_name")
    @Getter @Setter
    private String firstName;
    @Column(name="last_name")
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private char gender;
    @Getter @Setter
    private int age;

    @Override
    public String toString() {
        String actorString;
        actorString = "\nActor Id : " + getActorId();
        actorString += "\tFirst Name : " + getFirstName();
        actorString += "\tLast Name : " + getLastName();
        actorString += "\tGender : " + getGender();
        actorString += "\tAge : " + getAge() + "\n";
        return actorString;
    }
}
