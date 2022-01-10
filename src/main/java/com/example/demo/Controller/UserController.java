package com.example.demo.Controller;

import java.util.*;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}

    @GetMapping(path = "{id}")
    public Optional<User> getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }

    @GetMapping(path = "auth/{username}.{password}")
    public Optional<User> authUser(@PathVariable("username") String username, @PathVariable("password") String password){
        return userService.authentification(username, password);
    }

    
}
