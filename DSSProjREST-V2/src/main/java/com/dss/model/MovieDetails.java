package com.dss.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.List;

public class MovieDetails {
    @Getter
    private final Movie movie;
    @Getter
    private final List<Actor> actors;

    @JsonCreator
    public MovieDetails(Movie movie, List<Actor> actors){
        this.movie = movie;
        this.actors = actors;
    }
}
