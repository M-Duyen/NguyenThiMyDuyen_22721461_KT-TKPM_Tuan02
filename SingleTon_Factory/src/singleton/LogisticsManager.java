package singleton;

import java.io.Serializable;

public class LogisticsManager implements Serializable {
    private static final long serialVersionUID = 1L;

    private static class SingletonHelper {
        private static final LogisticsManager INSTANCE = new LogisticsManager();
    }

    private LogisticsManager() {
        if (SingletonHelper.INSTANCE != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static LogisticsManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }

    public void manage(String info) {
        System.out.println("Logisttics Coordinator: " + info);
    }
}