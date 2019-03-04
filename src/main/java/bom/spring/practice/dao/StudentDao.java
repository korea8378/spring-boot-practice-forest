package bom.spring.practice.dao;

import bom.spring.practice.domain.Student;
import bom.spring.practice.dto.RequestStudentDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getStudents() {
        return jdbcTemplate.query("select * from student", (rs, rowNum) -> new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
    }

    public int registerStudent(RequestStudentDto requestStudentDto) {
        return jdbcTemplate.update("insert into student (name, age) values (?, ?)", requestStudentDto.getName(), requestStudentDto.getAge());
    }

    public int removeStudent(int studentId) {
        return jdbcTemplate.update("delete from student where id = ?", studentId);
    }

    public int updateStudent(int studentId, RequestStudentDto requestStudentDto) {
        return jdbcTemplate.update("update student set name = ?, age = ? where id = ?", requestStudentDto.getName(), requestStudentDto.getAge(), studentId);
    }
}
