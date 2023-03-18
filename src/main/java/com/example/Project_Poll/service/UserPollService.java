package com.example.Project_Poll.service;


import com.example.Project_Poll.model.UserPollResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "userPoll",
        url = "${userPoll.url}"
)
public interface UserPollService {


    @GetMapping(value = "/user")
    UserPollResponse getUserById(@RequestParam Integer id);

    @DeleteMapping(value = "/user/delete")
    void deleteUser(@RequestParam Integer id);


}






