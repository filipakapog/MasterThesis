package cemadoare.service;

import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;
import cemadoare.testsmodes.TestSuite;
import cemadoare.util.Constants;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.*;

@PrepareForTest(JFileChooser.class)
public class TestFileSaver {

    public static final String TEST_FILE_TXT = "testFile.txt";
    @Mock
    JFileChooser fileChooser;

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    /**
     * Mocked private methods based on and enabled them in IntelliJ:
     *  1. https://github.com/powermock/powermock/wiki/TestNG
     *  2. https://goo.gl/CifSFK
     * @throws Exception
     */
    @Test(groups = {TestSuite.SLOW, TestSuite.BROKEN}, enabled = false, timeOut = 9000)
    public void testSaveToFile() throws Exception {
        // TODO: fix this test
        FileSaver fileSaver = getMock();
        fileSaver.saveFileTo(Constants.PATHS.MATLAB_DATA.getPath());

        // assert that a file exists there
        String expectedFilePath = Constants.PATHS.MATLAB_DATA.getPath() + TEST_FILE_TXT;
        assertThat(Files.exists(Paths.get(expectedFilePath)), is(true));
    }

    private FileSaver getMock() throws Exception {


        mock(JFileChooser.class);
        whenNew(JFileChooser.class).withNoArguments().thenReturn(fileChooser);
        when(fileChooser.getSelectedFile()).thenReturn(new File(TEST_FILE_TXT));

        FileSaver mock = spy(new FileSaver(mock(JPanel.class)));
        return mock;
    }
}
