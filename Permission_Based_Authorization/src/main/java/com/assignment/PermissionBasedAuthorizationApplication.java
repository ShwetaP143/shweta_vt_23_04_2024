package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.utils.JwtTokenUtil;

@SpringBootApplication
public class PermissionBasedAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PermissionBasedAuthorizationApplication.class, args);
	}

}
