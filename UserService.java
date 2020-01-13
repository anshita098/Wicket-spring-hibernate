package com.github.anirudhvarma12.whs;

import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserService {

	private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM userbank;";
    private static final String SQL_INSERT_USER =
            "INSERT INTO users (last_name, first_name, middle_name) VALUES (?, ?, ?);";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id = ?;";
    private static final String SQL_SELECT_USERS_BY_NAME =
            "SELECT * FROM userbank WHERE UPPER(last_name) LIKE UPPER(?) OR UPPER(first_name) " +
                    "LIKE UPPER(?) OR UPPER(middle_name) LIKE UPPER(?);";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM userbank WHERE id = ?";
    private static final String SQL_UPDATE_USER =
            "UPDATE userbank " +
                    "SET last_name = ?, first_name = ?, middle_name = ? WHERE id = ?;";

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
    public Collection<Bank> getUsers() {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	String sql = "SELECT * FROM USERBANK";

        List<Bank> customers = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Bank.class));

        return customers;
   
//        return jdbcTemplate.query(
//        		
//                SQL_SELECT_ALL_USERS,
//                userRowMapper()
//        );
    }

    


    public List<Bank> getUsersByName(String name) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
        return jdbcTemplate.query(
                SQL_SELECT_USERS_BY_NAME,
                new Object[]{name + "%", name + "%", name + "%"},
                userRowMapper()
        );
    }

    public Bank getUserById(int id) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
        List<Bank> userList = jdbcTemplate.query(SQL_SELECT_USER_BY_ID, new Object[]{id}, userRowMapper());
        return userList.get(0);
    }

    public void updateUser(int id, Bank user) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
    	String SQL = "update userbank set firstname = ?, email = ?, password = ?, age = ? where id = ?";
       
        jdbcTemplate.update(
                SQL,
                user.getEmail(), user.getFirstname(), user.getPassword(),user.getAge(), id
        );
    }

    private RowMapper<Bank> userRowMapper() {
        return (rs, rowNum) -> new Bank(
                rs.getString("firstname"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("age")
        );
    }
}
