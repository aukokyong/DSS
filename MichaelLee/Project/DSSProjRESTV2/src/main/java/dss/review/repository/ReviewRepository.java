package dss.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dss.review.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}