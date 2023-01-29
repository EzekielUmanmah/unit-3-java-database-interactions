package com.javaunit3.springmvc;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int movie_id;

    @Column(name = "title")
    private String title;

    @Column(name = "maturity_rating")
    private String maturity_rating;

    @Column(name = "genre")
    private String genre;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaturity_rating() {
        return maturity_rating;
    }

    public void setMaturity_rating(String maturity_rating) {
        this.maturity_rating = maturity_rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
