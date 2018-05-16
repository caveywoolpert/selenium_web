package lifebox;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dmitriy.Kruchek on 26.12.2017.
 */
public class TestSuiteRunner {
    private static Logger logger = LoggerFactory.getLogger(TestSuiteRunner.class);

    public static void main(String[] args) {
        Result resultAll = JUnitCore.runClasses(TestSuiteAll.class);

        resultAll.getFailures().forEach(failure -> {
            logger.warn(failure.toString());
        });

        logger.info("Test Suite execution was successful: " + resultAll.wasSuccessful());
    }
}
