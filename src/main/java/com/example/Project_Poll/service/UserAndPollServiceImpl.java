package com.example.Project_Poll.service;

import com.example.Project_Poll.model.*;
import com.example.Project_Poll.repository.UserAndPollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserAndPollServiceImpl implements UserAndPollService {

    @Autowired
    UserAndPollRepository userAndPollRepository;
    @Autowired
    UserPollService userPollService;


    @Override
    public UserAndPollResponse createUserAndPoll(UserAndPollRequest request) throws Exception {
        if (request.getUserPollResponse().getId() != null) {
            if (userPollService.getUserById(request.getUserPollResponse().getId()) != null) {
                userAndPollRepository.createUserAndPoll(request.toPoll());
                userAndPollRepository.updateQuestionId(request.toPoll());
                UserPollResponse userPollResponse = userPollService.getUserById(request.getUserPollResponse().getId());
                List<Poll> polls = userAndPollRepository.getPollUserById(userPollResponse.getId());
                UserAndPollResponse userAndPollResponse = new UserAndPollResponse(userPollResponse, polls);
                return userAndPollResponse;
            } else {
                throw new Exception("can't create poll without registered user");
            }
        } else {
            throw new Exception("can't create poll without user id");
        }

    }

    @Override
    public List<Poll> getPollUserById(Integer UserId) {
        return userAndPollRepository.getPollUserById(UserId);
    }

    @Override
    public void deleteAllPollUser(Integer userId) {
        userAndPollRepository.deleteAllPollUser(userId);
    }

    @Override
    public List getAnswerQuestionOptionByQuestionId(Integer questionId) {
        return userAndPollRepository.getAnswerQuestionOptionByQuestionId(questionId);

    }

    @Override
    public List getTotalAnswerQuestionByQuestionId(Integer questionId) {
        return userAndPollRepository.getTotalAnswerQuestionByQuestionId(questionId);
    }

    @Override
    public List getUserAnswersByUserId(Integer userId) {
        return userAndPollRepository.getUserAnswersByUserId(userId);
    }

    @Override
    public List getTotalAnswersByUserId(Integer userId) {
        return userAndPollRepository.getTotalAnswersByUserId(userId);
    }

    @Override
    public List getAllQuestionAndOptionQuestion() {
        return userAndPollRepository.getAllQuestionAndOptionQuestion();
    }


}
