package gui;

import service.FileSaver;
import service.MatlabFunctionCaller;
import logger.MyLogger;
import util.Constants;
import util.MyPropertyManager;

import javax.swing.*;
import java.awt.event.*;

public class MyGUI extends JFrame {

    private JPanel mainPanel;
    private JButton importButton;
    private JRadioButton arrhythmiaRadioButton;
    private JRadioButton stenosisRadioButton;
    private JComboBox comboBox1;
    private JTextPane applicationStatusTextPane;
    private JButton classifyButton;
    private JButton trainButton;
    private JTextPane applicationResultsTextPane;

    private boolean isTrained;
    private boolean isClassified;

    MatlabFunctionCaller matlabFunctionCaller;
    FileSaver fileSaver;
    MyLogger logger;

    private static final String FRAME_TITLE = "MyGUI";

    public MyGUI() {
        isTrained = false;
        isClassified = false;

        fileSaver = new FileSaver(mainPanel);
        matlabFunctionCaller = MatlabFunctionCaller.getInstance();
        matlabFunctionCaller.connectToMatlablEngine();
        logger = MyLogger.getInstance();

        setUpComponents();
        registerListeners();
    }

    private void setUpComponents() {
        setMainFrame();
        setTextFields();
    }

    private void setTextFields() {
        applicationStatusTextPane.setText("");
    }

    private void setMainFrame() {
        setTitle(FRAME_TITLE);
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

        // We can use an existing listener like WindowsAdapter instead
        // of implementing ourselves the WindowLister interface.
        // This way we override only the needed methods:
        //      + windowClosing()
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                // We need to do this, because it takes too much time to get a connection to Matlab.
                matlabFunctionCaller.disconnectFromMatlabEngine();
            }
        });
    }

    private void registerListeners() {
        importButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String matlabDataPath = Constants.PATHS.MATLAB_DATA.getPath();
                logger.logIn(applicationStatusTextPane, "Import was clicked");
                fileSaver.saveFileTo(matlabDataPath);
                logger.logIn(applicationStatusTextPane, "File saved to " + matlabDataPath);
            }
        });

        arrhythmiaRadioButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                logger.logIn(applicationStatusTextPane, "Arrhythmia data set was selected");
            }
        });

        stenosisRadioButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                logger.logIn(applicationStatusTextPane, "Stenosis data set was selected");
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String selected = String.valueOf(comboBox1.getSelectedItem());
                logger.logIn(applicationStatusTextPane, selected + "classifier was selected");
            }
        });

        classifyButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if (isTrained) {
                    logger.logIn(applicationStatusTextPane, "Starting classification");
                    isClassified = true;
                    matlabFunctionCaller.callClassifier();
                    logger.logIn(applicationResultsTextPane, "Results of the classification");
                } else {
                    logger.logErrorIn(applicationStatusTextPane, "First we need to train the classifier", true);
                }
            }
        });

        trainButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String selected = String.valueOf(comboBox1.getSelectedItem());
                logger.logIn(applicationStatusTextPane, selected + " is getting trained");
                // train the classifier
                isTrained = true;
                // prompt the user that training is done
            }
        });
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
