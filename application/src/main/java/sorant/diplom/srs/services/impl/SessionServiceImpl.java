package sorant.diplom.srs.services.impl;

import org.springframework.stereotype.Service;
import sorant.diplom.srs.entities.Session;
import sorant.diplom.srs.repositories.SessionRepository;
import sorant.diplom.srs.services.SessionService;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class SessionServiceImpl extends CRUDServiceImpl<Session, SessionRepository> implements SessionService {
    @Override
    public Session findByDateAndTime(LocalDate date, LocalTime time) {
        return repository.findByDateAndTime(date, time);
    }
}
