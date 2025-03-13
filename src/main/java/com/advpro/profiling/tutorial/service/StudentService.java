// StudentService.java

package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    // Mengambil semua student beserta course-nya dalam satu query
    public List<StudentCourse> getAllStudentsWithCourses() {
        return studentCourseRepository.findAllWithStudentAndCourse();
    }

    // Mencari student dengan GPA tertinggi
    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findAll().stream()
                .max((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()));
    }

    // Menggabungkan semua nama student jadi satu string, dipisahkan koma
    public String joinStudentNames() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }
}
