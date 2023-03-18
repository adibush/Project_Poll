package com.example.Project_Poll.model;

public class UserAndPollRequest {
    private UserPollResponse userPollResponse;
    private Poll poll;

    public UserAndPollRequest(UserPollResponse userPollResponse, Poll poll) {
        this.userPollResponse = userPollResponse;
        this.poll = poll;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public UserPollResponse getUserPollResponse() {
        return userPollResponse;
    }

    public void setUserPollResponse(UserPollResponse userPollResponse) {
        this.userPollResponse = userPollResponse;
    }

    public Poll toPoll() {
        return new Poll(
                this.poll.getQuestion_id(),
                this.poll.getTitle(),
                this.poll.getFirstAnswer(),
                this.poll.getSecondAnswer(),
                this.poll.getThirdAnswer(),
                this.poll.getFourthAnswer(),
                this.userPollResponse.getId(),
                this.poll.getAnswer());

    }

}
