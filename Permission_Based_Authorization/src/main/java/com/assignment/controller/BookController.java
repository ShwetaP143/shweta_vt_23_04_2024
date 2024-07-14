package com.assignment.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.annotation.Permission;
import com.assignment.enums.LogicEnum;
import com.assignment.enums.PermissionsEnum;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/books")
public class BookController {
	

	@Permission(permissions = {PermissionsEnum.AllowRead, PermissionsEnum.AllowWrite}, type = LogicEnum.All)
    @GetMapping("/data")
    public String getBook(@PathParam("/id") int id, @RequestParam("/num") Optional<Integer> num) {
        System.out.println(num);
        return "hello";
    }

}
