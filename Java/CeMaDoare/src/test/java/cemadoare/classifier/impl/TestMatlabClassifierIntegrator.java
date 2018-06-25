package cemadoare.service;

import cemadoare.classifer.impl.MatlablClassifierIntegrator;
import cemadoare.testsmodes.TestSuite;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestMatlabClassifierIntegrator {

    private Writer logFetcher;
    private Appender appender;

    @BeforeMethod
    public void setup() {
        logFetcher = new StringWriter(); // So that we can get access to the log
        appender = new WriterAppender(new SimpleLayout(), logFetcher);
        Logger.getLogger(MatlablClassifierIntegrator.class).addAppender(appender);
    }

    @AfterMethod
    void tearDown() {
        Logger.getLogger(MatlablClassifierIntegrator.class).removeAppender(appender);
    }

    @Test(groups = TestSuite.SLOW, timeOut = 18000)
    public void checkConnectivity() {
        MatlablClassifierIntegrator matlabFunctionCaller = MatlablClassifierIntegrator.getInstance();
        assertThat(matlabFunctionCaller, is(notNullValue()));
        matlabFunctionCaller = null;
    }

    @Test(groups = TestSuite.SLOW, timeOut = 18000)
    /**
     * Based on this code snipped https://www.programcreek.com/java-api-examples/?api=org.apache.log4j.WriterAppender
     */
    public void testDisconnectMatlabEngineWithoutPriorConnection() {
        MatlablClassifierIntegrator matlabFunctionCaller = MatlablClassifierIntegrator.getInstance();
        matlabFunctionCaller = null;

        //Check that we log everything correctly
        assertThat(logFetcher.toString().contains("No MATLAB connection opened"), is(true));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 18000)
    public void testDisconnectMatlabEngineWithPriorConnection() {
        MatlablClassifierIntegrator matlabFunctionCaller = MatlablClassifierIntegrator.getInstance();
        matlabFunctionCaller = null;
        //Check that we log everything correctly
        assertThat(logFetcher.toString().contains("MATLAB connection closed"), is(true));
    }
}