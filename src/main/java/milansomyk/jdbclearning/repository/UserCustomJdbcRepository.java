package milansomyk.jdbclearning.repository;

import milansomyk.jdbclearning.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
