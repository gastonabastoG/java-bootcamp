package meetingrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import meetingrest.entities.Attendee;
import meetingrest.entities.Room;
import meetingrest.repositories.IAttendeeRepository;
import meetingrest.repositories.IRoomRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Component
class AttendeesCommandLineRunner implements CommandLineRunner {

	@Autowired
	IAttendeeRepository attendeeRepository;
	@Autowired
	IRoomRepository roomRepository;

	@Override
	public void run(String... arg0) throws Exception {

		for (Attendee a : this.attendeeRepository.findAll()) {
			System.out.println(a.toString());
		}
		for (Room r : this.roomRepository.findAll()) {
			System.out.println(r.toString());
		}

	}
}
