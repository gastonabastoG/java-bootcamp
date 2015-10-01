package meetingrest.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import meetingrest.entities.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {
	Collection<Room> findByDescription(String description);
}