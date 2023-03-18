package com.example.Project_Poll.controller;

import com.example.Project_Poll.model.UserPollResponse;
import com.example.Project_Poll.service.UserAndPollService;
import com.example.Project_Poll.service.UserPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserPollController {

    @Autowired
    UserPollService userPollService;
    @Autowired
    UserAndPollService userAndPollService;


    @GetMapping(value = "/user")
    UserPollResponse getUserById(@RequestParam Integer id) {
        return userPollService.getUserById(id);
    }

    @DeleteMapping(value = "/user/delete")
    void deleteUser(@RequestParam Integer id) {
        userPollService.deleteUser(id);
        userAndPollService.deleteAllPollUser(id);

    }


}
