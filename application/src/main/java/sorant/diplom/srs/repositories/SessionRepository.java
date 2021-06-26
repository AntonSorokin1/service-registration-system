package sorant.diplom.srs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sorant.diplom.srs.entities.Session;

import java.time.LocalDate;
import java.time.LocalTime;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    Session findByDateAndTime(LocalDate date, LocalTime time);
}
