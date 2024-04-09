package milansomyk.jdbclearning.repository;

import milansomyk.jdbclearning.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserCustomJdbcRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    public UserCustomJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public User getAllUsers(){
        String GET_QUERY = "SELECT * FROM USERS WHERE id = 1";
        return jdbcTemplate.queryForObject(GET_QUERY, null, (rs,rowNum)-> new User(rs.getLong("id"),rs.getString("name"),rs.getString("surname"),rs.getString("email")));
    }
}
