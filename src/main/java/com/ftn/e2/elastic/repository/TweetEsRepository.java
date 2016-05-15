package com.ftn.e2.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ftn.e2.elastic.entity.TweetEsEntity;

public interface TweetEsRepository extends ElasticsearchRepository<TweetEsEntity, Long> {

}
