package com.example.Project_Poll.repository;

import com.example.Project_Poll.model.Poll;
import com.example.Project_Poll.repository.mapper.PollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PollRepositoryImpl implements PollRepository {

    private static final String POLL_TABLE_NAME = "poll";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void postPoll(Poll poll) {
        String sql = String.format("INSERT INTO %s (question_title,question_first_answer,question_second_answer,question_third_answer,question_fourth_answer)VALUES(?,?,?,?,?)", POLL_TABLE_NAME);
        jdbcTemplate.update(sql,
                poll.getTitle(),
                poll.getFirstAnswer(),
                poll.getSecondAnswer(),
                poll.getThirdAnswer(),
                poll.getFourthAnswer());
    }

    @Override
    public void deletePoll(int id) {
        String sql = String.format("DELETE FROM %s WHERE question_id = ?", POLL_TABLE_NAME);
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updatePoll(Poll poll) {
        String sql = String.format("UPDATE %s SET question_title=?,question_first_answer=?,question_second_answer=?,question_third_answer=?,question_fourth_answer=? WHERE question_id=?", POLL_TABLE_NAME);
        jdbcTemplate.update(sql,
                poll.getTitle(),
                poll.getFirstAnswer(),
                poll.getSecondAnswer(),
                poll.getThirdAnswer(),
                poll.getFourthAnswer(),
                poll.getQuestion_id());
    }

    @Override
    public Poll getPollById(Integer id) {
        String sql = String.format("SELECT * FROM %s WHERE question_id=?", POLL_TABLE_NAME);
        try {
            Poll poll = jdbcTemplate.queryForObject(sql, new PollMapper(), id);
            return poll;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
