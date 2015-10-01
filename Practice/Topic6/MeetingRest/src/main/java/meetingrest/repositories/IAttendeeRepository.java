package meetingrest.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import meetingrest.entities.Attendee;

public interface IAttendeeRepository extends JpaRepository<Attendee, Long> {
	Collection<Attendee> findByFirstName(String firstName);
}
