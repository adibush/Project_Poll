package com.example.Project_Poll.model;

import java.util.List;

public class UserAndPollResponse {
    private UserPollResponse userPollResponse;
    private List<Poll> polls;

    public UserAndPollResponse(UserPollResponse userPollResponse, List<Poll> polls) {
        this.userPollResponse = userPollResponse;
        this.polls = polls;
    }

    public UserPollResponse getUserPollResponse() {
        return userPollResponse;
    }

    public void setUserPollResponse(UserPollResponse userPollResponse) {
        this.userPollResponse = userPollResponse;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }
}
