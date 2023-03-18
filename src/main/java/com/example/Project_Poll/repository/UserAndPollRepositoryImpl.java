package com.example.Project_Poll.repository;

import com.example.Project_Poll.model.Poll;
import com.example.Project_Poll.repository.mapper.PollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserAndPollRepositoryImpl implements UserAndPollRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String POLL_TABLE = "poll";


    @Override
    public void createUserAndPoll(Poll poll) {
        String sql = String.format("INSERT INTO %s(question_title,question_first_answer,question_second_answer,question_third_answer,question_fourth_answer,user_id,answer)VALUES (?,?,?,?,?,?,?)", POLL_TABLE);
        jdbcTemplate.update(sql, poll.getTitle(), poll.getFirstAnswer(), poll.getSecondAnswer(), poll.getThirdAnswer(), poll.getFourthAnswer(), poll.getUserId(), poll.getAnswer());
    }


    @Override
    public List<Poll> getPollUserById(Integer UserId) {
        String sql = String.format("SELECT * FROM %s WHERE user_id=?", POLL_TABLE);
        return jdbcTemplate.query(sql, new PollMapper(), UserId);
    }

    @Override
    public void updateQuestionId(Poll poll) {
        String sql = String.format("UPDATE %s SET question_id=? WHERE question_title=?", POLL_TABLE);
        jdbcTemplate.update(sql, 1, "Between the following, what do you most love to do?");
        String sql2 = String.format("UPDATE %s SET question_id=? WHERE question_title=?", POLL_TABLE);
        jdbcTemplate.update(sql2, 2, "Where is your preferred place to travel?");

    }

    @Override
    public void deleteAllPollUser(Integer userId) {
        String sql = String.format("DELETE FROM %s WHERE user_id=?", POLL_TABLE);
        jdbcTemplate.update(sql, userId);

    }

    @Override
    public List getAnswerQuestionOptionByQuestionId(Integer questionId) {
        String sql = String.format("SELECT COUNT(user_id),answer FROM %s WHERE question_id=? GROUP BY answer ", POLL_TABLE);
        try {
            return jdbcTemplate.queryForList(sql, questionId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List getTotalAnswerQuestionByQuestionId(Integer questionId) {
        String sql = String.format("SELECT COUNT(answer) FROM %s WHERE question_id=?", POLL_TABLE);
        try {
            return jdbcTemplate.queryForList(sql, questionId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List getUserAnswersByUserId(Integer userId) {
        String sql = String.format("SELECT answer,question_id FROM %s WHERE user_id=? GROUP BY answer,question_id ORDER BY question_id", POLL_TABLE);
        try {
            return jdbcTemplate.queryForList(sql, userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public List getTotalAnswersByUserId(Integer userId) {
        String sql = String.format("SELECT COUNT(answer) FROM %s WHERE user_id=?", POLL_TABLE);
        try {
            return jdbcTemplate.queryForList(sql, userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List getAllQuestionAndOptionQuestion() {
        String sql = String.format("SELECT COUNT(answer),answer,question_id FROM %s GROUP BY answer,question_id ORDER BY question_id", POLL_TABLE);
        try {
            return jdbcTemplate.queryForList(sql);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
