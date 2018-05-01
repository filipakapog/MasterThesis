package util;

import org.testng.annotations.Test;
import testsmodes.TestSuite;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestMyPropertyManager {

    @Test(groups = TestSuite.BROKEN)
    public void testGetProperty() {
        // TODO Fix this test
        assertThat(MyPropertyManager.getProperty("matlab.function"), is("Test"));
    }
}