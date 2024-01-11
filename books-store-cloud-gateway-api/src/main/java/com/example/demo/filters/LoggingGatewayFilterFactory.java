package com.example.demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Component
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

	@Override
	public GatewayFilter apply(Config config) {
		
		return (exchange,chain)->{
			// Pre-processing
			if(config.isPreLogger()) {
				logger.info("Pre gateway filter logging: "+config.getBaseMessage());
			}
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				
				//post - processing
				if(config.isPostLogger()) {
					logger.info("Post gateway filter logging: "+config.getBaseMessage());
				}
			}));
					
		};
	
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Config{
		//specify your configurations
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;
	}
	
	private final Logger logger=LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);
	
	public LoggingGatewayFilterFactory() {
		super(Config.class);
	}

}
