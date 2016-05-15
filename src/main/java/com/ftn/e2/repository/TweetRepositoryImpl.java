package com.ftn.e2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ftn.e2.model.TweetEntity;

public class TweetRepositoryImpl implements TweetRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TweetEntity> searchTweets(final String query) {
		final Query q = em.createQuery("SELECT DISTINCT x FROM TweetEntity x WHERE x.text LIKE :query");
		q.setParameter("query", '%' + query + '%');

		final List<TweetEntity> results = q.getResultList();
		return results;
	}

}