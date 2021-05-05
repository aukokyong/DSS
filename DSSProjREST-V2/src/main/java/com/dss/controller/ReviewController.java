package com.dss.controller;

import com.dss.model.Review;
import com.dss.repository.ReviewRepository;
import com.dss.util.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//http://localhost:8080/dss/api
@RequestMapping("/api")
public class ReviewController {
	@Autowired
	ReviewRepository reviewRepository;
	@GetMapping("/reviews")
	public List<Review> findAllreviews() {
		List<Review> reviewsList =  reviewRepository.findAll(); 
		reviewsList.forEach(Colors::pc);
		return reviewsList;
	}
	
	@GetMapping("/reviews/{id}")
	public Review findReviewById(@PathVariable(value="id") Long reviewId) {
		Optional<Review> optionalReview = reviewRepository.findById(reviewId);
		Review review = optionalReview.get();
		Colors.pc(review);
		return review;
	}
	
	@PostMapping("/reviews")
	public Review createReview(@RequestBody Review review) {
	      Colors.pc("Inserting " + review);
	      Review reviewReturned = reviewRepository.save(review);
	      Colors.pc("Inserted " + review);
		return reviewReturned;
	}
	@PutMapping("/reviews/{id}")
	public Review updateReview(@PathVariable(value="id") Long reviewId, @RequestBody Review review) {
		Optional<Review> optionalReview = reviewRepository.findById(reviewId);
		Review reviewFromDB = optionalReview.get();
		reviewFromDB.setDatePosted(review.getDatePosted());
		reviewFromDB.setDescription(review.getDescription());
		reviewFromDB.setRating(review.getRating());
	      Colors.pc("Updating " + review);
	      Review reviewReturned = reviewRepository.save(reviewFromDB);
	      Colors.pc("Updated " + review);
		return reviewReturned;
	}

	   @DeleteMapping("/reviews/{id}")
	   public boolean deleteReview(@PathVariable(value = "id") Long reviewId) {
	      reviewRepository.deleteById(reviewId);
	      Colors.pc("Deleted " + reviewId);
	      return true;
	   }
	
}