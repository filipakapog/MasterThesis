package cemadoare.service;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import org.apache.log4j.Logger;
import cemadoare.util.MyPropertyManager;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class MatlabFunctionCaller {

    private static volatile MatlabFunctionCaller instance;

    private static final Logger LOGGER = Logger.getLogger(MatlabFunctionCaller.class);

    private Future<MatlabEngine> enginesBag;
    private MatlabEngine engine;

    private MatlabFunctionCaller() {}

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

    public void connectToMatlablEngine() {
        if (enginesBag == null || enginesBag.isCancelled()) {
            // Start a MATLAB session if the future is null or is cancelled
            enginesBag = MatlabEngine.startMatlabAsync();
            try {
                engine = enginesBag.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            LOGGER.info("Started Matlab engine asynchronously");
        } else {
            LOGGER.info("Active Matlab session present");
        }
    }

    public void callClassifier() {
        if (engine != null) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
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
            } finally {

            }
        } else {
            throw new RuntimeException("MatlabFunctionCaller.connectToMatlablEngine() was not called first");
        }
    }

    public void disconnectFromMatlabEngine() {
        try {
            if (engine != null) {
                LOGGER.info("Matlab engine session closed");
                engine.disconnect();
            } else {
                LOGGER.info("No Matlab engine session opened");
            }
        } catch (EngineException e) {
            e.printStackTrace();
        }
    }
}
