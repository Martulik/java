package Supervisor;

public class Supervisor extends Thread {

    private final AbstractProgram program = new AbstractProgram();

    private void monitorProgram() {
        while (true) {
            synchronized (program.getBell()) {
                program.waitBell();
                System.out.println("current state = " + program.getState());

                if (program.isNeedRestart()) {
                    startProgram();
                }
                if (program.isNeedStop()) {
                    stopProgram();
                    break;
                }
            }
        }
    }
    public void startProgram() {
        program.setState(Utils.State.RUNNING);
        System.out.println("Supervisor started program");
    }
    public void stopProgram() {
        program.setState(Utils.State.STOPPING);
        System.out.println("Supervisor stopped program");
    }

    @Override
    public void run() {
        new Thread(program).start();
        System.out.println("Supervisor started");
        monitorProgram();
    }
}
