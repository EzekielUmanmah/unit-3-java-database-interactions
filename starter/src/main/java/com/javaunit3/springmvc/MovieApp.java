package com.javaunit3.springmvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//  Add the appropriate annotation to the MovieApp class so that the project package is scanned for spring components
@ComponentScan
public class MovieApp {
    public static void main(String[] args) {
//        In the main method, get the application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieApp.class);

//        Using the application context, get the best movie service using the default bean id
//        (since we did not specify a bean id, the id will simply be the class name of the bean starting with a lower case).
        BestMovieService bestMovieService = context.getBean("bestMovieService", BestMovieService.class);

//        Just messing around
//        Movie batmanMovie = context.getBean("batmanMovie", Movie.class);
//        System.out.println(batmanMovie.getTitle());
//        System.out.println(batmanMovie.getGenre());
//        System.out.println(batmanMovie.getMaturityRating());
//
//        Movie titanicMovie = context.getBean("titanicMovie", TitanicMovie.class);
//        System.out.println(titanicMovie.getTitle());
//        System.out.println(titanicMovie.getGenre());
//        System.out.println(titanicMovie.getMaturityRating());

//        Using the best movie service, get the best movie
        Movie bestMovie = bestMovieService.getBestMovie();

//        Print out the title, maturity rating, and genre of the best movie
        System.out.println(bestMovie.getTitle());
        System.out.println(bestMovie.getGenre());
        System.out.println(bestMovie.getMaturityRating());

    }
}
