package gui.service;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import org.apache.log4j.Logger;
import util.MyPropertyManager;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class MatlabFunctionCaller {

    private static volatile MatlabFunctionCaller instance;
    private Future<MatlabEngine> enginesBag;
    private MatlabEngine engine;
    private final static Logger LOGGER = Logger.getLogger(MatlabFunctionCaller.class);

    private MatlabFunctionCaller() {
        if (enginesBag == null || enginesBag.isCancelled()) {
            // Start a MATLAB session if the future is null or is cancelled
            enginesBag = MatlabEngine.startMatlabAsync();
            LOGGER.info("MATLAB started asynchronously");
        } else {
            LOGGER.info("Active MATLAB session present");
        }
    }

    public static MatlabFunctionCaller getInstance() {
        if (instance == null) {
            synchronized (MatlabFunctionCaller.class) {
                if (instance == null) {
                    return new MatlabFunctionCaller();
                }
            }
        }
        return instance;
    }

    public void callClassifier() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    engine = enginesBag.get();
                    String matlabCodeHome = MyPropertyManager.getProperty("matlab.codeHome");
                    // move to location of Matlab code
                    engine.eval("cd " + matlabCodeHome);

                    // run the Matlab function
                    String matlabFunction = MyPropertyManager.getProperty("matlab.function");
                    engine.eval(matlabFunction);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void disconnectMatlabEngine() {
        try {
            if (engine != null) {
                LOGGER.info("MATLAB connection closed");
                engine.disconnect();

            }
        } catch (EngineException e) {
            e.printStackTrace();
        }
    }
}
