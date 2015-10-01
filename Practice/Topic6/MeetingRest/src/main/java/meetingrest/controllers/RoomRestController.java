package meetingrest.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meetingrest.entities.Room;
import meetingrest.repositories.IRoomRepository;

@RestController
class RoomRestController {

	@Autowired
	IRoomRepository roomRepository;

	@RequestMapping("/rooms")
	Collection<Room> rooms() {
		return this.roomRepository.findAll();
	}

}