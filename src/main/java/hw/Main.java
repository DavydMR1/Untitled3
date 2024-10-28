package hw;

import hw.aspects.TrackingAspect;
import hw.config.ProjectConfig;
import hw.models.Action;
import hw.services.DefaultService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(DefaultService.class);

        Action action = new Action();
        action.setText("<proceeding");
        action.setActive(true);

        String value = service.option1(action);
    }
}
