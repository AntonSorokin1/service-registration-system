package sorant.diplom.srs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sorant.diplom.srs.Session;
import sorant.diplom.srs.services.SessionService;

@RestController
@RequestMapping("/sessions")
public class SessionAPIController extends CRUDController<Session, SessionService> {

}
