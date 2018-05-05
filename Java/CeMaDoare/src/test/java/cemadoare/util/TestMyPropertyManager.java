package cemadoare.util;

import org.testng.annotations.Test;
import cemadoare.testsmodes.TestSuite;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestMyPropertyManager {

    @Test(groups = TestSuite.BROKEN, enabled = false)
    public void testGetProperty() {
        // TODO: fix this test
        assertThat(MyPropertyManager.getProperty("matlab.function"), is("Test"));
    }
}