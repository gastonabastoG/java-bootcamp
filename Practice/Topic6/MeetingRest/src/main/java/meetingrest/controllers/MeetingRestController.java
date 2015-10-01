package meetingrest.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import meetingrest.entities.Meeting;
import meetingrest.repositories.IMeetingRepository;

@RestController
@RequestMapping("/meetings")
class MeetingRestController {

	@Autowired
	IMeetingRepository meetingRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	Collection<Meeting> getAllMeetings() {
		return this.meetingRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Meeting getMeeting(@PathVariable long id) {
		return this.meetingRepository.findOne(id);
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
		Meeting m = meetingRepository.save(meeting);
		return new ResponseEntity<Meeting>(m, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	ResponseEntity<Meeting> updateMeeting(@RequestBody Meeting meeting) {
		if (meetingRepository.exists(meeting.getId())) {
			meetingRepository.delete(meeting.getId());
			Meeting m = meetingRepository.save(meeting);
			return new ResponseEntity<Meeting>(m, HttpStatus.OK);
		} else {
			return new ResponseEntity<Meeting>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "application/json")
	ResponseEntity<Meeting> deleteMeeting(@RequestBody Meeting meeting) {
		if (meetingRepository.exists(meeting.getId())) {
			meetingRepository.delete(meeting.getId());
			return new ResponseEntity<Meeting>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Meeting>(HttpStatus.NOT_FOUND);
		}
	}

}
