package cemadoare.service;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileSaver {
    private JFrame rootFrame;
    private JFileChooser fileChooser;

    public FileSaver(JFrame rootFrame) {
        this.fileChooser = new JFileChooser();
        this.rootFrame = rootFrame;
    }

    /**
     * Saves a .mat file in the locationToSave location.
     * @param locationToSave the place where the imported .mat file will be saved;
     */
    public void saveFileTo(String locationToSave) {
        fileChooser.showOpenDialog(rootFrame);
        File file = fileChooser.getSelectedFile(); if (null == file) { return; }

        RandomAccessFile fromFile = null;
        RandomAccessFile toFile = null;

        try {
            fromFile = new RandomAccessFile(file, "r");
            toFile = new RandomAccessFile(locationToSave + file.getName(), "rw");

            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();
            toChannel.transferFrom(fromChannel, position, count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fromFile != null) {
                try {
                    fromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (toFile != null) {
                try {
                    toFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
