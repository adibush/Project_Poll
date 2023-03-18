package com.example.Project_Poll.controller;

import com.example.Project_Poll.model.UserAndPollRequest;
import com.example.Project_Poll.model.UserAndPollResponse;
import com.example.Project_Poll.service.UserAndPollServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserAndPollController {
    @Autowired
    UserAndPollServiceImpl userAndPollService;

    @PostMapping(value = "/create/answer")
    public UserAndPollResponse createUserPoll(@RequestBody UserAndPollRequest request) throws Exception {
        return userAndPollService.createUserAndPoll(request);
    }

    @GetMapping(value = "/options/question", params = "question_id")
    public List getAnswerQuestionOptionByQuestionId(@RequestParam(value = "question_id") Integer questionId) {
        return userAndPollService.getAnswerQuestionOptionByQuestionId(questionId);
    }

    @GetMapping(value = "/total/question", params = "question_id")
    public List getTotalAnswerQuestionByQuestionId(@RequestParam(value = "question_id") Integer questionId) {
        return userAndPollService.getTotalAnswerQuestionByQuestionId(questionId);
    }

    @GetMapping(value = "/answer/user", params = "user_id")
    public List getUserAnswersByUserId(@RequestParam(value = "user_id") Integer userId) {
        return userAndPollService.getUserAnswersByUserId(userId);
    }

    @GetMapping(value = "/total/user", params = "user_id")
    public List getTotalAnswersByUserId(@RequestParam(value = "user_id") Integer userId) {
        return userAndPollService.getTotalAnswersByUserId(userId);
    }

    @GetMapping(value = "/all")
    public List getAllQuestionAndOptionQuestion() {
        return userAndPollService.getAllQuestionAndOptionQuestion();
    }


}
