package highSchool.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import highSchool.entities.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {

}
