package com.ftn.e2.service;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.e2.elastic.entity.TweetEsEntity;
import com.ftn.e2.elastic.entity.UserEsEntity;
import com.ftn.e2.elastic.repository.TweetEsRepository;
import com.ftn.e2.model.TweetEntity;
import com.ftn.e2.model.UserEntity;
import com.ftn.e2.repository.TweetRepository;
import com.ftn.e2.repository.UserRepository;

@Service
public class TweetService implements ITweetService {

	@Inject
	private TweetRepository tweetRepository;

	@Inject
	private TweetEsRepository tweetEsRepository;

	@Inject
	private UserRepository userRepository;

	@Override
	@Transactional
	public void processTweet(final Tweet tweetEntity) {

		final UserEntity user = findOrCreate(tweetEntity.getUser());
		if (user != null) {
			save(tweetEntity, user);
		}

		saveEs(tweetEntity);

	}

	private UserEntity findOrCreate(final TwitterProfile twitterProfile) {

		UserEntity user = userRepository.findUserByTwitterId(twitterProfile.getId() + "");
		if (user != null) {
			return user;
		}

		user = new UserEntity();
		user.setCreatedDate(twitterProfile.getCreatedDate());
		user.setDescription(twitterProfile.getDescription());
		user.setLocation(twitterProfile.getLocation());
		user.setName(twitterProfile.getName());
		user.setProfileUrl(twitterProfile.getProfileUrl());
		user.setProfilImageUrl(twitterProfile.getProfileImageUrl());
		user.setScreenName(twitterProfile.getScreenName());
		user.setTwitterId(twitterProfile.getId() + "");

		user = userRepository.save(user);
		return user;
	}

	private TweetEntity save(final Tweet tweetEntity, final UserEntity user) {
		TweetEntity tweet = new TweetEntity();
		tweet.setCreatedAt(tweetEntity.getCreatedAt());
		tweet.setLanguageCode(tweetEntity.getLanguageCode());
		tweet.setSource(tweetEntity.getSource());
		tweet.setText(tweetEntity.getText());
		tweet.setUser(user);

		if (tweetRepository != null) {
			tweet = tweetRepository.save(tweet);
			System.out.println(tweetEntity.getText());
			return tweet;
		}

		return null;
	}

	private TweetEsEntity saveEs(final Tweet tweetEntity) {
		final TwitterProfile twitterProfile = tweetEntity.getUser();

		final UserEsEntity user = new UserEsEntity();
		user.setCreatedDate(twitterProfile.getCreatedDate());
		user.setDescription(twitterProfile.getDescription());
		user.setLocation(twitterProfile.getLocation());
		user.setName(twitterProfile.getName());
		user.setProfileUrl(twitterProfile.getProfileUrl());
		user.setProfilImageUrl(twitterProfile.getProfileImageUrl());
		user.setScreenName(twitterProfile.getScreenName());
		user.setTwitterId(twitterProfile.getId() + "");

		TweetEsEntity esTweet = new TweetEsEntity();
		esTweet.setCreatedAt(tweetEntity.getCreatedAt());
		esTweet.setLanguageCode(tweetEntity.getLanguageCode());
		esTweet.setSource(tweetEntity.getSource());
		esTweet.setText(tweetEntity.getText());
		esTweet.setUser(user);

		if (tweetEsRepository != null) {
			esTweet = tweetEsRepository.save(esTweet);
			return esTweet;
		}

		return null;
	}
}