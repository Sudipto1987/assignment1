package com.sudipto.assignment1;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
	
	@Autowired
	private QuoteRepository qrepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/submit")
	public void submit(@RequestBody Quote quote) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
		
		quote.setTimestamp(timestamp);
		qrepository.save(quote);		
		
	}
	
	@GetMapping("/topFive")
	public List<Quote> returnTopFive() {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
		
		List<Quote> lQuote=qrepository.findAll();	
		
		logger.info("All Messages --> "+lQuote);
		
		List<Quote> returnQuoteList=new ArrayList<>();
		
		Iterator iter=lQuote.iterator();
		
		while(iter.hasNext()) {
			
			Quote q=(Quote) iter.next();
			
			long milliseconds1 = q.getTimestamp().getTime();
			long milliseconds2 = timestamp.getTime();
			
			long diff = milliseconds2 - milliseconds1;
			long diffSeconds = diff / 1000;
			long diffMinutes = diff / (60 * 1000);
			  
			if(diffMinutes<10) {
				
				if(returnQuoteList.size()<5)
					returnQuoteList.add(q);		
				else
					break;				
			}
			
		}
		
		return returnQuoteList;
		
	}

}
