package sorant.diplom.srs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sorant.diplom.srs.Customer;
import sorant.diplom.srs.Session;
import sorant.diplom.srs.dto.Appointment;
import sorant.diplom.srs.dto.Day;
import sorant.diplom.srs.dto.Time;
import sorant.diplom.srs.services.CustomerService;
import sorant.diplom.srs.services.SessionService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SessionService sessionService;

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/methods")
    public String methods() {
        return "methods";
    }

    @GetMapping("/appointment")
    public String appointment(Model model) {
        model.addAttribute("appointment", getDefaultAppointment());
        return "appointment";
    }

    @PostMapping("/appointment")
    public String appointment(@ModelAttribute Appointment appointment, Model model) {
        Customer appCustomer = new Customer(appointment.getName(), appointment.getAge(), appointment.getPhone(), appointment.getTheme());
        customerService.create(appCustomer);
        int customerId = customerService.findByNameAndAgeAndPhoneAndTheme(appointment.getName(), appointment.getAge(), appointment.getPhone(), appointment.getTheme()).getId();
        Session session = sessionService.findByDateAndTime(appointment.getDate(), appointment.getTime());
        session.setCustomerId(customerId);
        sessionService.update(session, session.getId());

        model.addAttribute("appointment", getDefaultAppointment());
        return "appointment";
    }

    private Appointment getDefaultAppointment() {
        Appointment appointment = new Appointment();
        List<Session> sessions = sessionService.readAll();

        Map<LocalDate, List<Time>> vacantDays = new HashMap<>();
        sessions.forEach(session -> {
            LocalDate localDate = session.getDate();
            LocalTime localTime = session.getTime();
            int duration = session.getDuration();

            String name = localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
            Time time = new Time(name, localTime, duration, session.getCustomerId() == 0);

            if (vacantDays.containsKey(localDate)) {
                vacantDays.get(localDate).add(time);
            } else {
                List<Time> timeList = new ArrayList<>();
                timeList.add(time);
                vacantDays.put(localDate, timeList);
            }
        });

        List<Day> resultDays = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int daysInMonth = currentDate.lengthOfMonth();
        LocalDate firstDayOfMonth = LocalDate.of(currentYear, currentMonth, 1);
        LocalDate lastDayOfMonth = LocalDate.of(currentYear, currentMonth, daysInMonth);
        LocalDate dayBefore = firstDayOfMonth.minusDays(firstDayOfMonth.getDayOfWeek().getValue());
        LocalDate dayAfter = lastDayOfMonth.plusDays(7L - lastDayOfMonth.getDayOfWeek().getValue());

        while (!dayBefore.equals(dayAfter)) {
            dayBefore = dayBefore.plusDays(1L);

            String name = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                    .withLocale(new Locale("ru"))
                    .format(dayBefore);
            name = name.substring(0, name.length() - 8);

            resultDays.add(new Day(name, dayBefore, new ArrayList<>(), false));
        }

        vacantDays.forEach((k, v) -> {
            resultDays.forEach(day -> {
                if (day.getDate().equals(k)) {
                    day.setTimes(v);
                    if (!day.getDate().isBefore(currentDate)) {
                        day.setActive(true);
                    }
                }
            });
        });

        appointment.setDays(resultDays);
        return appointment;
    }
}
