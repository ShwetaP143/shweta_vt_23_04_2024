package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.UserRoleMap;

@Repository
public interface UserRoleMapRepository extends JpaRepository<UserRoleMap, Long> {

}
