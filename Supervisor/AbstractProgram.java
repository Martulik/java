package Supervisor;

public class AbstractProgram implements Runnable {
    private final Object bell = new Object();
    private Utils.State current_state;

    public Utils.State getState() {
        return current_state;
    }

    public Object getBell() {
        return bell;
    }

    public void setState(Utils.State newState) {
        current_state = newState;
    }

    public boolean isNeedRestart() {
        return current_state == Utils.State.STOPPING || current_state == Utils.State.UNKNOWN;
    }

    public boolean isNeedStop() {
        return current_state == Utils.State.FATAL_ERROR;
    }

    @Override
    public void run() {
        Thread daemon = new Thread(() -> {
            while (true) {
                synchronized (bell) {
                    current_state = Utils.getRandomState();
                    bell.notify();
                    Utils.pause(100);
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();
        System.out.println("Abstract program started");
    }

    public void waitBell() {
        try {
            bell.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
