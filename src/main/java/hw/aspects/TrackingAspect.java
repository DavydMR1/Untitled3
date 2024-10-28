package hw.aspects;

import hw.models.Action;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class TrackingAspect {
    private Logger logger = Logger.getLogger(TrackingAspect.class.getName());
    @Around("execution(* hw.services.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();
        Action action = new Action();
        action.setText("<none>");
        action.setActive(false);
        Object[] newArguments = {action};

        Object proceed = joinPoint.proceed(newArguments);

        logger.info(methodName + " has been invoked with arguments " + Arrays.toString(args));
        return proceed;
    }

    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnable")
    public void log(Object returnable) {
        logger.info("Executed method: " + returnable);
    }
}
