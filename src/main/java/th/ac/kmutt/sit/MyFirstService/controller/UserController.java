package th.ac.kmutt.sit.MyFirstService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @GetMapping("/user/1")
    public User getUser(){
        return new User(1, "Nathawat");
    } 

    @GetMapping("/users")
    public User[] getAllUser(){
        User[] list = {new User(1, "Test"), new User(2, "Test"), new User(3, "Test"), new User(4, "Test")};
        return list;

    }

}