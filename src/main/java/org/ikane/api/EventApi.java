package org.ikane.api;

import org.ikane.dto.Person;
import org.ikane.event.EventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventApi {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventApi.class);

	@Autowired
	private EventPublisher eventPublisher;
	
	@GetMapping("publish-person")
	public String createAndPublishPerson (@RequestParam(value = "firstName") String firstName, 
										  @RequestParam(value = "lastName") String lastName, 
										  @RequestParam(value = "age") int age) {
		
		Person p = new Person(firstName, lastName, age);
		
		try {
			this.eventPublisher.publishPerson(p);
			
			return "OK";
		} catch (Exception e) {
			LOGGER.error("error", e);
			
			return "NOK";
		}
	}
	
	
}
