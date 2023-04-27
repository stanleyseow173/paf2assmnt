package ibf2022.paf.assessment.server.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.paf.assessment.server.models.User;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        User user = new User();

        user.setUserId(rs.getString("user_id"));
        user.setUsername(rs.getString("username"));
        user.setName(rs.getString("name"));

        return user;
    }
    

}
