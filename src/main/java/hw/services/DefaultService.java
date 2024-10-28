package hw.services;

import hw.annotations.TrackUserAction;
import hw.models.Action;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Component
@Service
public class DefaultService {
    private Logger logger = Logger.getLogger(DefaultService.class.getName());

    @TrackUserAction
    public String option1(Action action) {
        action.setText("<waiting>");
        return "Action set to <waiting>";
    }

    public String option2(Action action) {
        action.setActive(false);
        return "Action terminated";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
