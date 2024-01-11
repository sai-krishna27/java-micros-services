package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class ScdfSinkApplication {

	private static Logger logger=LoggerFactory.getLogger(ScdfSinkApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ScdfSinkApplication.class, args);
	}
	
	@StreamListener(Sink.INPUT)
	public void loggerSink(String date) {
		logger.info("Sink Received: "+date);
	}

}