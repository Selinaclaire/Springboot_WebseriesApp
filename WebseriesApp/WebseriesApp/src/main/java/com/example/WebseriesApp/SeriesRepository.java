package com.example.WebseriesApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
	List<Series> findById(@Param("id") int id);
	
	@Transactional
	List<Series> findByName(@Param("name") String name);


}
