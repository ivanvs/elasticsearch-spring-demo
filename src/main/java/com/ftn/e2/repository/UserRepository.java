package com.ftn.e2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.e2.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>, UserRepositoryCustom {

}