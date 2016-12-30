package com.ftn.e2.controller;

import java.util.List;

import javax.inject.Inject;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.e2.elastic.entity.TweetEsEntity;
import com.ftn.e2.elastic.repository.TweetEsRepository;
import com.ftn.e2.model.TweetEntity;
import com.ftn.e2.repository.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TwitterController {

	@Inject
	private TweetEsRepository tweetEsRepository;

	@Inject
	private TweetRepository tweetRepository;

	@RequestMapping(value = "/es", method = RequestMethod.POST)
	public ResponseEntity<?> queryEs(@RequestBody final QueryDto query) {

		final QueryBuilder esQuery = QueryBuilders.simpleQueryStringQuery(query.getQuery());

		final Iterable<TweetEsEntity> results = tweetEsRepository.search(esQuery);
		return new ResponseEntity<Iterable<TweetEsEntity>>(results, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/sql", method = RequestMethod.POST)
	public ResponseEntity<?> querySql(@RequestBody final QueryDto query) {
		final List<TweetEntity> results = tweetRepository.searchTweets(query.getQuery());
		return new ResponseEntity<List<TweetEntity>>(results, HttpStatus.ACCEPTED);
	}
}
