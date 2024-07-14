package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	UserRole findByName(String roleName);

}
