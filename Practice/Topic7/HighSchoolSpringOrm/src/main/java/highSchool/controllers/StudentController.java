package highSchool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import highSchool.dao.IStudentRepository;
import highSchool.entities.Course;
import highSchool.entities.Student;

@Component
public class StudentController {

	@Autowired
	IStudentRepository studentRepo;

	public void create(Student student) {
		studentRepo.save(student);
	}

	public void delete(long id) {
		studentRepo.delete(id);
	}

	public void update(long id, Student student) {
		Student s = getById(id);
		if (s != null) {
			s.setFirstName(student.getFirstName());
			s.setLastName(student.getLastName());
			s.setBirthDate(student.getBirthDate());
			studentRepo.save(s);
		}
	}

	public Student getById(long id) {
		return studentRepo.findOne(id);
	}

	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	public List<Course> getCoursesByStudentId(long id) {
		Student s = getById(id);
		if (s != null) {
			return s.getAllCourses();
		} else {
			return null;
		}

	}

}
