package bom.spring.practice.dto;

import bom.spring.practice.domain.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentDto {

    private int id;

    private String name;

    private int age;

    private StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }

    public static StudentDto from(Student student) {
        return new StudentDto(student);
    }
}
