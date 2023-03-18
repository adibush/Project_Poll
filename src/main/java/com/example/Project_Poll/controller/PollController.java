package com.example.Project_Poll.controller;

import com.example.Project_Poll.model.Poll;
import com.example.Project_Poll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/poll")
public class PollController {
    @Autowired
    PollService service;


    @PostMapping(value = "/create")
    public String createPoll(@RequestBody Poll poll) {
        service.postPoll(poll);
        return "poll created";
    }


    @PutMapping(value = "/update")
    public String updatePoll(@RequestBody Poll poll) {
        service.updatePoll(poll);
        return "poll update";
    }

    @DeleteMapping(value = "/delete")
    public String deletePoll(@RequestParam int id) {
        service.deletePoll(id);
        return "poll deleted";
    }

    @GetMapping(params = "id")
    public Poll getPollById(@RequestParam int id) {
        return service.getPollById(id);
    }


}
