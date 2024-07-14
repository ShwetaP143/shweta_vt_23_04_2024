package com.assignment.service;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.User;
import com.assignment.model.UserRole;
import com.assignment.repository.PerRoleMapRepository;
import com.assignment.repository.UserRepository;
import com.assignment.repository.UserRoleMapRepository;
import com.assignment.repository.UserRoleRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleMapRepository userRoleMapRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PerRoleMapRepository perRoleMapRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<String> getUserRoles(String email) {
        User user = getUserByEmail(email);
        return userRoleMapRepository.findAll().stream()
                .filter(userRoleMap -> userRoleMap.getUser().getId().equals(user.getId()))
                .map(userRoleMap -> userRoleMap.getRole().getName())
                .collect(Collectors.toList());
    }

    public List<String> getPermissionsByRole(String roleName) {
        UserRole role = userRoleRepository.findByName(roleName);
        return perRoleMapRepository.findAll().stream()
                .filter(perRoleMap -> perRoleMap.getRole().getId().equals(role.getId()))
                .map(perRoleMap -> perRoleMap.getPermission().getName())
                .collect(Collectors.toList());
    }
}
