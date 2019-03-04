package bom.spring.practice.service;

import bom.spring.practice.dao.StudentDao;
import bom.spring.practice.dto.RequestStudentDto;
import bom.spring.practice.dto.StudentListDto;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentListDto getStudents() {
        return StudentListDto.from(studentDao.getStudents());
    }

    public void registerStudent(RequestStudentDto requestStudentDto) {
        int result = studentDao.registerStudent(requestStudentDto);

        if(result == 0) {
            //throw exception
        }
    }

    public void removeStudent(int studentId) {
        int result = studentDao.removeStudent(studentId);

        if(result == 0) {
            //throw exception
        }
    }

    public void updateStudent(int studentId, RequestStudentDto requestStudentDto) {
        int result = studentDao.updateStudent(studentId, requestStudentDto);

        if(result == 0) {
            //throw exception
        }
    }
}
