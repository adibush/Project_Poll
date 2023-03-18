package com.example.Project_Poll.repository;

import com.example.Project_Poll.model.Poll;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public interface UserAndPollRepository {
    void createUserAndPoll(Poll poll);
    List<Poll> getPollUserById(Integer UserId);

    void  updateQuestionId(Poll poll);

    void deleteAllPollUser(Integer userId);

    List getAnswerQuestionOptionByQuestionId(Integer questionId);

    List getTotalAnswerQuestionByQuestionId(Integer questionId);

    List getUserAnswersByUserId(Integer userId);

    List getTotalAnswersByUserId(Integer userId);

    List getAllQuestionAndOptionQuestion();




}
