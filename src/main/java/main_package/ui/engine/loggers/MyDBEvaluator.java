package main_package.ui.engine.loggers;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.spi.ContextAwareBase;
import org.jetbrains.annotations.NotNull;

public class MyDBEvaluator extends ContextAwareBase implements EventEvaluator<ILoggingEvent> {
    public long last = 0;

    @Override
    public boolean evaluate(@NotNull ILoggingEvent event) throws NullPointerException, EvaluationException {
        if (last - event.getTimeStamp() > 15000) {
            return true;
        }
        System.out.println("helllo world");
        System.out.println("helllo world");
        System.out.println("helllo world");
        System.out.println("helllo world");
        System.out.println("helllo world");
        System.out.println("helllo world");
        System.out.println("helllo world");
        System.out.println("helllo world");
        last = event.getTimeStamp();
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }
}
