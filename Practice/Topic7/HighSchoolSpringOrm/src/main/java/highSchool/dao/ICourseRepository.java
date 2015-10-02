package highSchool.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import highSchool.entities.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {

}
