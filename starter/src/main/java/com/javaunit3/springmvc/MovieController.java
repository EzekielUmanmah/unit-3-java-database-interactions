package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private BestMovieService bestMovieService;

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/voteForBestMovieForm")
    public String voteForBestMovieForm(Model model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        session.getTransaction().commit();

        model.addAttribute("movies", movieEntityList);

        return "voteForTheBestMovie";
    }

    @RequestMapping("/addMovieForm")
    public String addMovieForm(){
        return "addMovie";
    }

    @RequestMapping("/addMovie")
    public void addMovie(@RequestParam(name = "title") String title,
                           @RequestParam(name = "maturityRating") String rating,
                           @RequestParam(name = "genre") String genre){
//        create movie object
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(title);
        movieEntity.setMaturityRating(rating);
        movieEntity.setGenre(genre);

//        sessionFactory.getCurrentSession()
        Session session = sessionFactory.getCurrentSession();
//        start session
        session.beginTransaction();
//        save movie object to db
        session.save(movieEntity);
//        commit the transaction
        session.getTransaction().commit();
//        printing anything after still inserts the data but errors the View
    }

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMovie(Model model) {
        model.addAttribute("BestMovie", bestMovieService.getBestMovie().getTitle());
        return "bestMovie";
    }

    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model) {
        String movieTitle = request.getParameter("movieTitle");
        model.addAttribute("bestMovie", movieTitle);

        return "voteForTheBestMovie";
    }
}
