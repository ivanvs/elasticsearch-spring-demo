package com.ftn.e2.service;

import java.util.concurrent.BlockingQueue;

import org.springframework.social.twitter.api.Tweet;

public class TweetProcessor implements Runnable {

	private final ITweetService tweetService;

	private final BlockingQueue<Tweet> queue;

	public TweetProcessor(final BlockingQueue<Tweet> queue, final ITweetService tweetService) {
		this.queue = queue;
		this.tweetService = tweetService;
	}

	@Override
	public void run() {
		while (true) {
			try {
				final Tweet tweet = queue.take();
				processTweet(tweet);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void processTweet(final Tweet tweetEntity) {
		try {
			tweetService.processTweet(tweetEntity);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
