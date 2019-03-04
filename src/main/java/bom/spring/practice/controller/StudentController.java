package bom.spring.practice.controller;

import bom.spring.practice.dto.RequestStudentDto;
import bom.spring.practice.dto.StudentDto;
import bom.spring.practice.dto.StudentListDto;
import bom.spring.practice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public ResponseEntity<StudentListDto> getStudents() {

        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }

    @PostMapping(value = "/students")
    public ResponseEntity registerStudent(@RequestBody RequestStudentDto requestStudentDto) {

        studentService.registerStudent(requestStudentDto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/students/{studentId}")
    public ResponseEntity removeStudent(@PathVariable(value = "studentId") int studentId) {

        studentService.removeStudent(studentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping(value = "/students/{studentId}")
    public ResponseEntity updateStudent(@PathVariable(value = "studentId") int studentId,
                                                    @ModelAttribute RequestStudentDto requestStudentDto) {
        studentService.updateStudent(studentId, requestStudentDto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}