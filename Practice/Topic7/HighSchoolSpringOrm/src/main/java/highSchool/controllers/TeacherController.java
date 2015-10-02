package highSchool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import highSchool.dao.ITeacherRepository;
import highSchool.entities.Teacher;

@Component
public class TeacherController {

	@Autowired
	ITeacherRepository teacherRepo;

	public void create(Teacher teacher) {
		teacherRepo.save(teacher);
	}

	public void delete(long id) {
		teacherRepo.delete(id);
	}

	public void update(long id, Teacher teacher) {
		Teacher t = getById(id);
		if (t != null) {
			t.setFirstName(teacher.getFirstName());
			t.setLastName(teacher.getLastName());
			t.setBirthDate(teacher.getBirthDate());
			teacherRepo.save(t);
		}
	}

	public Teacher getById(long id) {
		return teacherRepo.findOne(id);
	}

	public List<Teacher> getAll() {
		return teacherRepo.findAll();
	}

}
