package highSchool.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import highSchool.entities.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

}
