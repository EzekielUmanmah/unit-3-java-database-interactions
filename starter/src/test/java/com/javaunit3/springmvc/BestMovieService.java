package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BestMovieService {
    @Autowired
    private Movie movie;

    public Movie getBestMovie() {
        return movie;
    }
}
