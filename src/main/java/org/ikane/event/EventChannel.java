package org.ikane.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventChannel {

	String OUTPUT_CHANNEL = "outputChannel";
	
	@Output(OUTPUT_CHANNEL)
	MessageChannel outputChannel();
}
