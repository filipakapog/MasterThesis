package cemadoare.logger;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class MyLogger {
    private static volatile MyLogger instance;

    private MyLogger() {}

    public static MyLogger getInstance() {
        if (instance == null) {
            synchronized (MyLogger.class) {
                if (instance == null) { return new MyLogger(); }
            }
        }

        return instance;
    }

    public void logIn(JTextPane pane, String msg) {
        logErrorIn(pane, msg, false);
    }

    public void logErrorIn(JTextPane pane, String msg, boolean isError) {
        Document document = pane.getStyledDocument();

        try {
            if (isError) {
                StyleContext styleContext = StyleContext.getDefaultStyleContext();
                AttributeSet attributeSet = styleContext.addAttribute(SimpleAttributeSet.EMPTY,
                        StyleConstants.Foreground, Color.RED);

                document.insertString(document.getLength(), getTime() + "[ERROR] " + msg + "\n", attributeSet);
            } else {
                document.insertString(document.getLength(), getTime() + msg + "\n", null);
            }
        } catch (BadLocationException e) {
            // something bad has happen
            e.printStackTrace();
        }
    }

    public String getTime() {
        StringBuilder timeStamp = new StringBuilder();
        timeStamp.append("[Timestamp ")
                .append(new SimpleDateFormat("HH:mm:ss").format(new Date()))
                .append("]: ");
        return timeStamp.toString();
    }
}
