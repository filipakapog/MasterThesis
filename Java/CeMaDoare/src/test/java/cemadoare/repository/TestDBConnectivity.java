package cemadoare.repository;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import cemadoare.testsmodes.TestSuite;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.testng.FileAssert.fail;

@Test
public class TestDBConnectivity {
    private final static Logger LOGGER = Logger.getLogger(TestDBConnectivity.class);
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static final String DB_CONNECTIVITY = "DB_CONNECTIVITY";

    @Test(groups = {DB_CONNECTIVITY, TestSuite.SLOW}, timeOut = 6000)
    public void testConnectivity() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Class.forName("org.h2.Driver");
            LOGGER.info("Connected successfully");
        } catch (Exception e) {
            fail("Could not connect to the db");
        }
    }

}
