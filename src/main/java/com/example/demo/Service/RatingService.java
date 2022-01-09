package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Rating;
import com.example.demo.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    
    public List<Rating> getRatings(){
		return ratingRepository.findAll();
	}

    public Optional<Rating> getRating(Long id){
        return ratingRepository.findById(id);
    }

    public void addNewRating(Rating rating) {
        ratingRepository.save(rating);
    }

    public void deleteRating(long id) {
        if (ratingRepository.existsById(id)){
            ratingRepository.deleteById(id);
        } else throw new IllegalStateException("Rating with id " +id  + " does not exist");
    }

}
