package com.example.Project_Poll.service;

import com.example.Project_Poll.model.Poll;
import com.example.Project_Poll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {

    @Autowired
    PollRepository repository;


    @Override
    public void postPoll(Poll poll) {
        repository.postPoll(poll);


    }

    @Override
    public void deletePoll(int id) {
        repository.deletePoll(id);

    }

    @Override
    public void updatePoll(Poll poll) {
        repository.updatePoll(poll);

    }

    @Override
    public Poll getPollById(int id) {
        return repository.getPollById(id);
    }
}
