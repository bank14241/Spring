package th.ac.kmutt.sit.MyFirstService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    private User[] userList = {
            new User(1, "test1"),
            new User(2, "test2"),
            new User(3, "test3"),
            new User(4, "test4")
    };

    @GetMapping("/user/{id}")
    public User getUserByIdUri(@PathVariable("id") int id){
        return userList[id-1];
    }

    @GetMapping("/user/1")
    public User getUser(){
        return new User(1, "Nathawat");
    } 

    @GetMapping("/users")
    public User[] getAllUser(){
        return userList;
    }

    @GetMapping("/user")
    public User getUserByIdAttribute(@RequestParam("id") int id){
        return userList[id-1];
    }



}