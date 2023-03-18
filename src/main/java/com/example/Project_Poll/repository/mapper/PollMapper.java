package com.example.Project_Poll.repository.mapper;

import com.example.Project_Poll.model.Poll;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollMapper implements RowMapper<Poll> {
    @Override
    public Poll mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Poll(rs.getInt("question_id"),
                rs.getString("question_title"),
                rs.getString("question_first_answer"),
                rs.getString("question_second_answer"),
                rs.getString("question_third_answer"),
                rs.getString("question_fourth_answer"),
                rs.getInt("user_id"),
                rs.getString("answer"));
    }

}
