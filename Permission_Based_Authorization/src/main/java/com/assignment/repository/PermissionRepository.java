package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {

}
