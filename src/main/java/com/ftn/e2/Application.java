package com.ftn.e2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@EnableElasticsearchRepositories("eu.ftn.e2.elastic.repository")
@SpringBootApplication
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ThreadPoolTaskExecutor taskExecutor(final @Value("${taskExecutor.corePoolSize}") int corePoolSize,
			final @Value("${taskExecutor.maxPoolSize}") int maxPoolSize,
			final @Value("${taskExecutor.queueCapacity}") int queueCapacity) {
		final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(corePoolSize);
		taskExecutor.setMaxPoolSize(maxPoolSize);
		taskExecutor.setQueueCapacity(queueCapacity);
		return taskExecutor;
	}

	@Bean
	// Params injected from application.properties file:
	public Twitter twitter(final @Value("${spring.social.twitter.appId}") String appId,
			final @Value("${spring.social.twitter.appSecret}") String appSecret,
			final @Value("${spring.social.twitter.accessToken}") String accessToken,
			final @Value("${spring.social.twitter.accessTokenSecret}") String accessTokenSecret) {
		return new TwitterTemplate(appId, appSecret, accessToken, accessTokenSecret);
	}
}
