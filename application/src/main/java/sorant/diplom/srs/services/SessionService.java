package sorant.diplom.srs.services;

import sorant.diplom.srs.entities.Session;

import java.time.LocalDate;
import java.time.LocalTime;

public interface SessionService extends CRUDService<Session>{
    Session findByDateAndTime(LocalDate date, LocalTime time);
}
