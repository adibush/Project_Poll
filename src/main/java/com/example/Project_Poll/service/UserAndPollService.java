package com.example.Project_Poll.service;

import com.example.Project_Poll.model.Poll;
import com.example.Project_Poll.model.UserAndPollRequest;
import com.example.Project_Poll.model.UserAndPollResponse;

import java.util.List;
import java.util.Map;

public interface UserAndPollService {
    UserAndPollResponse createUserAndPoll(UserAndPollRequest request) throws Exception;

    List<Poll> getPollUserById(Integer UserId);

    void deleteAllPollUser(Integer userId);

    List getAnswerQuestionOptionByQuestionId(Integer questionId);

    List getTotalAnswerQuestionByQuestionId(Integer questionId);

    List getUserAnswersByUserId(Integer userId);

    List getTotalAnswersByUserId(Integer userId);

    List getAllQuestionAndOptionQuestion();

}
