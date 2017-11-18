package org.ikane.event;

import org.ikane.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(EventChannel.class)
public class EventPublisher {
	
	@Autowired
	private EventChannel channel;
	
	public void publishPerson(Person p) {
		
		//Person p = new Person("Ibrahima", "KANE", 37);
		
		this.channel.outputChannel().send(MessageBuilder.withPayload(p).build());
		
	}

}
