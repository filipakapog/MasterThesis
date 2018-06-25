package cemadoare.classifer.impl;

import cemadoare.classifer.ClassifierIntegrator;
import cemadoare.classifer.DataSetType;
import cemadoare.util.MyPropertyManager;
import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MatlablClassifierIntegrator implements ClassifierIntegrator {

    private static volatile MatlablClassifierIntegrator instance;

    private static final Logger LOGGER = Logger.getLogger(MatlablClassifierIntegrator.class);

    private Future<MatlabEngine> enginesBag;
    private MatlabEngine engine;

    private MatlablClassifierIntegrator() {
        connectToMatlablEngine();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        disconnectFromMatlabEngine();

    }

    private void connectToMatlablEngine() {
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

    public static MatlablClassifierIntegrator getInstance() {
        if (instance == null) {
            synchronized (MatlablClassifierIntegrator.class) {
                if (instance == null) {
                    return new MatlablClassifierIntegrator();
                }
            }
        }
        return instance;
    }

    private void disconnectFromMatlabEngine() {
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

    @Override
    public void classify(DataSetType type) {
        if (engine != null) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        if (DataSetType.ARRYTHMIA == type) {
                            String matlabCodeHome = MyPropertyManager.getProperty("matlab.codeHome");
                            // move to location of Matlab code
                            engine.eval("cd " + matlabCodeHome);

                            // run the Matlab function
                            String matlabFunction = MyPropertyManager.getProperty("matlab.function");
                            engine.eval(matlabFunction);
                            LOGGER.info("Doing classification on Arrythmia dataset");
                        } else if (DataSetType.STENOSIS == type) {

                            LOGGER.info("Doing classification on Stenosis dataset");
                        } else {
                            LOGGER.info("No valid dataset, skipping from doing anything");
                        }
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
}
