package com.example.Project_Poll.repository;

import com.example.Project_Poll.model.Poll;

import java.util.List;

public interface PollRepository {

    void postPoll(Poll poll);

    void deletePoll(int id);

    void updatePoll(Poll poll);

    Poll getPollById(Integer id);


}
