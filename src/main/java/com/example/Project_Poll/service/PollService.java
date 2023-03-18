package com.example.Project_Poll.service;

import com.example.Project_Poll.model.Poll;

public interface PollService {
    void postPoll(Poll poll);
    void deletePoll(int id);
    void updatePoll(Poll poll);

    Poll getPollById(int id);
}
