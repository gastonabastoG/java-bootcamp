package meetingrest.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meetingrest.entities.Attendee;
import meetingrest.repositories.IAttendeeRepository;

@RestController
class AttendeeRestController {

	@Autowired
	IAttendeeRepository attendeeRepository;
	
	@RequestMapping("/attendees")
	Collection<Attendee> attendees() {
		return this.attendeeRepository.findAll();
	}

}