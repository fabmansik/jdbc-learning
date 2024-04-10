package milansomyk.jdbclearning.repository;

import lombok.extern.slf4j.Slf4j;
import milansomyk.jdbclearning.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Slf4j
@Repository
public class UserCustomJdbcRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    public UserCustomJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> getAllUsers(){
        String GET_QUERY = "SELECT * FROM USERS";
        return jdbcTemplate.query(GET_QUERY, new BeanPropertyRowMapper<>(User.class));
    }
    public void multiUpdate(){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springjdbc")){
            connection.setAutoCommit(false);
            try (Statement stmt = connection.createStatement()){
                stmt.execute("DELETE * FROM USERS WHERE id = 2");
                stmt.execute("DELETE * FROM USERS WHERE id = 3");

                connection.commit();
            }catch (SQLException e){
                log.error("Error while doing deleting users! Error: {}",e.getMessage());
                try{
                    connection.rollback();
                }catch (SQLException t){
                    log.error("Error while doing rollback! Error:{}",t.getMessage());
                }
        }
        } catch (SQLException e) {
            log.error("Error while creating connection! Error:{}",e.getMessage());
        }
    }
}
