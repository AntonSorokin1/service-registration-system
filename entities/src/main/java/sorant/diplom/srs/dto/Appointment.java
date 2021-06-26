package sorant.diplom.srs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private String name;
    private int age;
    private String phone;
    private String email;
    private String theme;

    private List<Day> days;

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", time=" + time +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", theme='" + theme + '\'' +
                ", days=" + days +
                '}';
    }
}
