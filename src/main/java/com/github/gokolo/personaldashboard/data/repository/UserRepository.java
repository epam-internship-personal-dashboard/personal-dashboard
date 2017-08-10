package com.github.gokolo.personaldashboard.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.gokolo.personaldashboard.data.entities.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
    UserEntity findByUsername(final String username);
}
