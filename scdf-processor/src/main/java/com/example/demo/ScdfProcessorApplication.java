package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
@SpringBootApplication
public class ScdfProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScdfProcessorApplication.class, args);
	}
	
	@Transformer(inputChannel = Processor.INPUT,
			outputChannel=Processor.OUTPUT)
	public Object transform(Long date) {
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

}
