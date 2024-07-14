package com.assignment.test;

import com.assignment.utils.JwtTokenUtil;

public class TestJwt {


	    public static void main(String[] args) {
	        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
	        String token = jwtTokenUtil.generateToken("john.doe@example.com", "AllowRead,AllowWrite");
	        System.out.println("JWT Token: " + token);
	    }
	}


