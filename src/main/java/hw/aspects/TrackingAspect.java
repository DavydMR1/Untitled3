package hw.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class TrackingAspect {
    private Logger logger = Logger.getLogger(TrackingAspect.class.getName());
    @Around("@annotation(hw.annotations.TrackUserAction)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTIme = System.currentTimeMillis() - start;
        String methodName = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature() + " executed in " + executionTIme + " ms\n");
        logger.info(methodName + " has been invoked with arguments " + Arrays.toString(args));
        return proceed;
    }
}
