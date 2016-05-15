package com.ftn.e2.service;

import org.springframework.social.twitter.api.Tweet;

public interface ITweetService {

	void processTweet(final Tweet tweetEntity);
}