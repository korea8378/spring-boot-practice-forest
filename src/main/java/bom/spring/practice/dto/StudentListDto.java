package bom.spring.practice.dto;

import bom.spring.practice.domain.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class StudentListDto {

    private List<StudentDto> students;

    private  StudentListDto(List<Student> students) {
        this.students = students.stream().map(StudentDto::from).collect(Collectors.toList());
    }

    public static StudentListDto from(List<Student> students) {
        return new StudentListDto(students);
    }
}
