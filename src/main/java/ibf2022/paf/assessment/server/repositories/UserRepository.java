package ibf2022.paf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;
import static ibf2022.paf.assessment.server.repositories.DBQueries.*;

// TODO: Task 3

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<User> findUserByUsername(String username){

        System.out.println("went here first ---------------------------------->");
        try{
            User user = jdbcTemplate.queryForObject(SELECT_USERNAME, new UserRowMapper(), new Object[]{username});  
            return Optional.of(user);
        }catch (Exception e){
             return Optional.empty();
        }
    }


    public String insertUser(User user){
        String userId = UUID.randomUUID().toString().substring(0, 8);
        
        int row = jdbcTemplate.update(INSERT_USER, userId, user.getUsername(),user.getName());

        if (row>0){
            return userId;
        }

        return null;
    }

}
