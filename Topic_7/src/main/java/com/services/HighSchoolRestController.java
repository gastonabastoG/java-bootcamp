package com.services;

import java.util.List;

import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entities.Course;
import com.entities.Student;
import com.entities.Teacher;

@RestController
@RequestMapping("/highschool")
public class HighSchoolRestController {

	@Autowired
	private final HighSchoolService highSchoolService;

	@Autowired
	public HighSchoolRestController(HighSchoolService highSchoolService) {
		this.highSchoolService = highSchoolService;
	}

	@RequestMapping(value = "/{student}", method = RequestMethod.PUT)
	ResponseEntity<?> addStudent(@PathVariable Student s) {
		highSchoolService.addStudent(s);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{student}").buildAndExpand(s).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{teacher}", method = RequestMethod.PUT)
	ResponseEntity<?> addTeacher(@PathVariable Teacher t) {
		highSchoolService.addTeacher(t);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{teacher}").buildAndExpand(t).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{course}", method = RequestMethod.PUT)
	ResponseEntity<?> addCourse(@PathVariable Course c) {
		highSchoolService.addCourse(c);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{course}").buildAndExpand(c).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{registration}", method = RequestMethod.PUT)
	ResponseEntity<?> addRegistration(@PathVariable Registration r) {
		highSchoolService.addRegistration(r);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{registration}").buildAndExpand(r).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		return highSchoolService.getAllStudents();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Teacher> getAllTeachers() {
		return highSchoolService.getAllTeachers();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Course> getAllCourses() {
		return highSchoolService.getAllCourses();
	}

	@RequestMapping(value = "/{registrationNumber}", method = RequestMethod.GET)
	public List<Course> getAllCoursesOfStudent(@PathVariable int registrationNumber){
		return highSchoolService.getAllCoursesOfStudent(registrationNumber);
	}

	@RequestMapping(value = "/{idCourse}", method = RequestMethod.GET)
	public List<Student> getAllStudents(@PathVariable int idCourse){
		return highSchoolService.getAllStudents(idCourse);
	}

}
