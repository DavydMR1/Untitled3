package hw.services;

import hw.annotations.TrackUserAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultService {
    @TrackUserAction
    public String option1(String a) {
        a = a.toUpperCase();
        return a;
    }

    public String option2(String a) {
        a = a.toUpperCase();
        return a;
    }
}
