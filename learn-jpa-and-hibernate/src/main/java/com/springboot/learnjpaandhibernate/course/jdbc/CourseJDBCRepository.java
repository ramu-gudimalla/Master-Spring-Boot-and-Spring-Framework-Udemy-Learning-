package com.springboot.learnjpaandhibernate.course.jdbc;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static String INSERT_QUERY =
            """
                    INSERT INTO course(id, name, author)
                    VALUES (?,?,?);
            """;
    public static String DELETE_QUERY = """
            DELETE FROM course WHERE id = ?
            """;
    public static String SELECT_QUERY = """
            SELECT * FROM course WHERE id = ?
            """;
    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }
    public void deleteById(Long id){
        jdbcTemplate.update(DELETE_QUERY,id);
    }
    public Course findById(Long id){
        // ResultSet -> Bean => Row Mapper =>
        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),id);
    }
}
