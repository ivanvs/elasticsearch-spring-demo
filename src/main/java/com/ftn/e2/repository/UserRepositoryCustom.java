package com.ftn.e2.repository;

import com.ftn.e2.model.UserEntity;

public interface UserRepositoryCustom {

	UserEntity findUserByTwitterId(String id);
}