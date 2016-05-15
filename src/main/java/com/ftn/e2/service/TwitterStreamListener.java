package com.ftn.e2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

@Service
public class TwitterStreamListener implements StreamListener {

	@Inject
	private Twitter twitter;

	@Inject
	private ThreadPoolTaskExecutor taskExecutor;

	@Value("${twitterProcessing.enabled}")
	private boolean processingEnabled;

	@Inject
	private ITweetService tweetService;

	private final BlockingQueue<Tweet> queue = new ArrayBlockingQueue<Tweet>(20);

	public void run() {
		final List<StreamListener> listeners = new ArrayList<StreamListener>();
		listeners.add(this);
		twitter.streamingOperations().sample(listeners);
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		if (processingEnabled) {
			for (int i = 0; i < taskExecutor.getMaxPoolSize(); i++) {
				taskExecutor.execute(new TweetProcessor(queue, tweetService));
			}

			run();
		}
	}

	@Override
	public void onTweet(final Tweet tweet) {
		queue.offer(tweet);
	}

	@Override
	public void onDelete(final StreamDeleteEvent deleteEvent) {
	}

	@Override
	public void onLimit(final int numberOfLimitedTweets) {
	}

	@Override
	public void onWarning(final StreamWarningEvent warningEvent) {
	}
}
