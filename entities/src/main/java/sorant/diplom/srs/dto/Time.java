package sorant.diplom.srs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time {
    private String name;
    private LocalTime localTime;
    private int duration;
    private boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time1 = (Time) o;
        return localTime.equals(time1.localTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localTime);
    }
}
