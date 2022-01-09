package com.example.demo.Controller;

import java.util.*;

import com.example.demo.Model.Rating;
import com.example.demo.Service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    
    @GetMapping
	public List<Rating> getRatings(){
		return ratingService.getRatings();
	}

    @PostMapping
    public void registerNewRating(@RequestBody Rating rating){
        ratingService.addNewRating(rating);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRating(@PathVariable("id") long id){
        ratingService.deleteRating(id);
    }

    
}
