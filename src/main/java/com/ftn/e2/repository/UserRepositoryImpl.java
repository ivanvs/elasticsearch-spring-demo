package com.ftn.e2.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ftn.e2.model.UserEntity;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserEntity findUserByTwitterId(final String id) {
		try {
			final Query q = em.createQuery("SELECT DISTINCT x FROM UserEntity x WHERE x.twitterId = :id");
			q.setParameter("id", id);

			final UserEntity user = (UserEntity) q.getSingleResult();
			return user;
		} catch (final NoResultException e) {
			return null;
		}

	}
}