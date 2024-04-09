package milansomyk.jdbclearning.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class JdbcService {
    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    @PostConstruct
    @Transactional
    public void getAll() {
        jdbcTemplate.execute("CREATE TABLE USERS (id integer PRIMARY KEY , name VARCHAR(60), surname VARCHAR(60), email VARCHAR(120))");
        System.out.println("table is created!");
        jdbcTemplate.update("INSERT INTO USERS VALUES (?,?,?,?)", 2, "Gon", "Sanchez", "gonsanchez@gmail.com");
        jdbcTemplate.update("INSERT INTO USERS VALUES (?,?,?,?)", 1, "Bill", "Gates", "billgates@gmail.com");
    }
}
