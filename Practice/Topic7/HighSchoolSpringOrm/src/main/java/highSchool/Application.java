package highSchool;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import highSchool.controllers.CourseController;
import highSchool.controllers.StudentController;
import highSchool.controllers.TeacherController;
import highSchool.entities.Course;
import highSchool.entities.Student;
import highSchool.entities.Teacher;

@SpringBootApplication
public class Application {

	@Autowired
	TeacherController teacherController;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Component
class LineRunner implements CommandLineRunner {

	@Autowired
	TeacherController teacherController;

	@Autowired
	StudentController studentController;

	@Autowired
	CourseController courseController;

	public void run(String... args) throws Exception {
		// Calls to run the Controllers's methods of the exercise.

		// TeacherController test
		teacherController.create(new Teacher("Pedro", "Gonzales", Timestamp.from(Instant.now())));
		teacherController.update(4, new Teacher("Pedro", "Garcia", Timestamp.from(Instant.now())));
		teacherController.delete(8);
		System.out.println(teacherController.getById(1).toString());
		for (Teacher t : teacherController.getAll()) {
			System.out.println(t.toString());
		}

		// StudentController test
		studentController.create(new Student("Ale", "Rojas", Timestamp.from(Instant.now())));
		studentController.update(21, new Student("Ale", "Pereira", Timestamp.from(Instant.now())));
		studentController.delete(21);
		System.out.println(studentController.getById(1).toString());
		for (Student s : studentController.getAll()) {
			System.out.println(s.toString());
		}

		// getCoursesByStudentId and getStudentsByCourseId methods
		for (Course c : studentController.getCoursesByStudentId(1)) {
			System.out.println(c.toString());
		}
		for (Student s : courseController.getStudentsByCourseId(1)) {
			System.out.println(s.toString());
		}

	}
}
