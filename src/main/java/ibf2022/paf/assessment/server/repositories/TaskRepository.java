package ibf2022.paf.assessment.server.repositories;

import org.ietf.jgss.GSSName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;
import static ibf2022.paf.assessment.server.repositories.DBQueries.*;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// TODO: Task 6

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int insertTask(String username, Task task){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        LocalDate taskDate = task.getDate();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/DD");
        Date sqlDate = Date.valueOf(taskDate.toString());
        System.out.println("Date is ------------------------> " + sqlDate);

        jdbcTemplate.update(conn -> {
            PreparedStatement statement = conn.prepareStatement(INSERT_TASK, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, task.getDescription());
            statement.setInt(2, task.getPriority());
            statement.setDate(3, sqlDate);
            statement.setString(4,username);
            return statement;
        }, keyHolder);

        BigInteger primaryKey = (BigInteger) keyHolder.getKey();

        return primaryKey.intValue();
    }
}
