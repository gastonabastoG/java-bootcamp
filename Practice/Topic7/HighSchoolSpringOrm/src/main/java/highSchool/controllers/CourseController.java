package highSchool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import highSchool.dao.ICourseRepository;
import highSchool.entities.Course;
import highSchool.entities.Student;

@Component
public class CourseController {

	@Autowired
	ICourseRepository courseRepo;

	public void create(Course course) {
		courseRepo.save(course);
	}

	public void delete(long id) {
		courseRepo.delete(id);
	}

	public void update(long id, Course course) {
		Course c = getById(id);
		if (c != null) {
			c.setName(course.getName());
			c.setHoursByWeek(course.getHoursByWeek());
			c.setYear(course.getYear());
			c.setTeacher(course.getTeacher());
			courseRepo.save(c);
		}
	}

	public Course getById(long id) {
		return courseRepo.findOne(id);
	}

	public List<Course> getAll() {
		return courseRepo.findAll();
	}

	public List<Student> getStudentsByCourseId(long id) {
		Course c = getById(id);
		if (c != null) {
			return c.getAllStudents();
		} else {
			return null;
		}

	}

}