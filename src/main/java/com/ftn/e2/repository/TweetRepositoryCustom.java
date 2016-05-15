package com.ftn.e2.repository;

import java.util.List;

import com.ftn.e2.model.TweetEntity;

public interface TweetRepositoryCustom {

	List<TweetEntity> searchTweets(String query);
}