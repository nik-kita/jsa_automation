package ui.engine.loggers;
import static net.logstash.logback.argument.StructuredArguments.*;

import org.slf4j.Logger;
import org.slf4j.MDC;
import org.testng.*;

import java.lang.reflect.Method;
import java.util.List;

public class MySpecialLoggerUpdater {
    public static Logger beforeSuite(Logger logger, ITestContext context) {
        ISuite suite = context.getSuite();
        String name = suite.getName();
        Integer allMethods = suite.getAllMethods().size();
        MDC.put("suite", name);
        MDC.put("testsInSuite", allMethods.toString());
        logger.info("The '" + name + "' suite is start!");
        return logger;
    }
    public static Logger afterSuite(Logger logger, ITestContext context) {
        ISuite suite = context.getSuite();
        String name = suite.getName();
        int allMethods = suite.getAllMethods().size();
        int runMethods = suite.getAllInvokedMethods().size();
        if(allMethods == runMethods) {
            logger.info("All tests in '" + name + "' suite tested!");
        } else if(allMethods - runMethods > allMethods / 2) {
            logger.warn("Not all tests in '" + name + "' suite tested! (" +runMethods + ")");
        } else {
            logger.error("Expected to test " + allMethods + " tests in '" + name + "' suite but run only " + runMethods);
        }
        MDC.clear();
        return logger;
    }
    public Logger beforeClass(Method method) {
        //TODO
        return null;
    }

}
