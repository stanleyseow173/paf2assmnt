package ibf2022.paf.assessment.server.repositories;

public class DBQueries {
    
    public static final String SELECT_USERNAME = "select * from user where username = ?;";

    public static final String INSERT_USER ="INSERT INTO user (user_id, username, name) VALUES (?, ?, ?);";

    //public static final String INSERT_TASK = "INSERT INTO task (description, priority, due_date, username ) VALUES ('testing', 3, '2029-03-13', 'asdjsh08');";
    public static final String INSERT_TASK = "INSERT INTO task (description, priority, due_date, username) VALUES (?, ?, ?, ?);";
}
