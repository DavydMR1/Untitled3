package hw.config;

import hw.aspects.TrackingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "hw")
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    public TrackingAspect aspect() {
        return new TrackingAspect();
    }
}