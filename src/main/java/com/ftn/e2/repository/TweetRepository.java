package com.ftn.e2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.e2.model.TweetEntity;

public interface TweetRepository extends JpaRepository<TweetEntity, Integer>, TweetRepositoryCustom {

}
