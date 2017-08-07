package com.github.gokolo.personaldashboard.repositiory;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.gokolo.personaldashboard.entities.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {

}
