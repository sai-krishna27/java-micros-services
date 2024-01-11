package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public class EmployeeRegistrationConsumer {
	@RabbitListener(queues= {"${rabbitmq.queue.name}"})
	public void comsume(Employee employee) {
		System.out.println("Message arrived is - Message: "+employee);
	}
}
