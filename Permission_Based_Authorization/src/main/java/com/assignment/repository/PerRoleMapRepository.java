package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.PerRoleMap;

@Repository
public interface PerRoleMapRepository extends JpaRepository<PerRoleMap, Long> {

}
