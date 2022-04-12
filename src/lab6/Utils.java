package lab6;

public class Utils {
    public enum State {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR;
    }

    private static final State[] states = State.values();

    public static State getRandomState() {
        int randIndex = (int) (Math.random() * 4);
        return states[randIndex];
    }

    public static void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
