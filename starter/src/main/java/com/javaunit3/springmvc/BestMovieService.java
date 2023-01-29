package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BestMovieService {
    //    Remove the Autowired annotation from the movie field.
//    @Autowired
//    @Qualifier("titanicMovie")
    private Movie movie;

    @Autowired
    public BestMovieService(@Qualifier("titanicMovie") Movie movie) {
        this.movie = movie;
    }

//    Create a setter method setMovie() that takes a movie object as input. Annotate the method so
//    that Spring will use the method to inject the Movie object.
//    @Autowired
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }

    public Movie getBestMovie() {
        return movie;
    }
}
