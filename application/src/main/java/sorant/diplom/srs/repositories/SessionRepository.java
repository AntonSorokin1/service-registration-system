package sorant.diplom.srs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sorant.diplom.srs.Session;

import java.time.LocalDate;
import java.time.LocalTime;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    Session findByDateAndTime(LocalDate date, LocalTime time);
}
