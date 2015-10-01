package meetingrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import meetingrest.entities.Meeting;

public interface IMeetingRepository extends JpaRepository<Meeting, Long> {

}
