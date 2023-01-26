package com.javaunit3.springmvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//  Add the appropriate annotation to the MovieApp class so that the project package is scanned for spring components
@ComponentScan
public class MovieApp {
    public static void main(String[] args) {
//        In the main method, get the application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieApp.class);

//        Using the application context, get the best movie service using the default bean id
//        (since we did not specify a bean id, the id will simply be the class name of the bean starting with a lower case).
        BestMovieService bestMovieService = context.getBean("bestMovieService", BestMovieService.class);

//        Using the best movie service, get the best movie
        Movie bestMovie = bestMovieService.getBestMovie();

//        Print out the title, maturity rating, and genre of the best movie
        System.out.println(bestMovie.getTitle());
        System.out.println(bestMovie.getGenre());
        System.out.println(bestMovie.getMaturityRating());

    }
}
