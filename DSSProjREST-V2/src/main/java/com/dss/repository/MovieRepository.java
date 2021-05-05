package com.dss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dss.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
