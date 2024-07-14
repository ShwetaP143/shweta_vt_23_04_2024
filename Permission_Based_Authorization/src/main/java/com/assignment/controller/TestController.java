package com.assignment.controller;

import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.annotation.Permission;
import com.assignment.enums.LogicEnum;
import com.assignment.enums.PermissionsEnum;

@RestController
public class TestController {

	@Permission(permissions = {PermissionsEnum.AllowRead, PermissionsEnum.AllowWrite}, type = LogicEnum.All)
	    @GetMapping("/test")
	    public String test() {
	        return "Access granted!";
	    }
}
