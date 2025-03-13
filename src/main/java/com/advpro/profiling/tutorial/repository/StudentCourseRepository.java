// StudentCourseRepository.java

package com.advpro.profiling.tutorial.repository;

import com.advpro.profiling.tutorial.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    // Ambil semua StudentCourse beserta student & course-nya dalam satu query
    @Query("SELECT sc FROM StudentCourse sc JOIN FETCH sc.student JOIN FETCH sc.course")
    List<StudentCourse> findAllWithStudentAndCourse();

    // Jika masih dibutuhkan untuk use case lain
    List<StudentCourse> findByStudentId(Long studentId);
}
