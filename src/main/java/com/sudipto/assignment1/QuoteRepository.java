package com.sudipto.assignment1;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Timestamp> {
	
	
	

}
