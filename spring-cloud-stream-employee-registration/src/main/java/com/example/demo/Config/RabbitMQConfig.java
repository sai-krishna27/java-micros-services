package com.example.demo.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queue;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Bean
	public Queue createQueue() {
		return new Queue(queue);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	@Bean
	public Binding binding(Queue queue,TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}
	
	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {

		SimpleMessageListenerContainer container=new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		return container;
	}
	
	
}
