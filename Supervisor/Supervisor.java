package Supervisor;

/* Создать супервизор (управляющую программу), которая контролирует исполнение абстрактной программы.
        Абстрактная программа работает в отдельном потоке и является классом с полем перечисляемого типа, который
        отражает ее состояние (UNKNOWN, STOPPING, RUNNING, FATAL ERROR) и имеет поток демон случайного состояния,
        который в заданном интервале меняет её состояние на случайное.
        У супервизора должны быть методы остановки и запуска абстрактной программы, которые меняют ее состояние.
        Супервизор является потоком, который циклически опрашивает абстрактную программу, и если ее состояние UNKNOWN
        или STOPPING, то перезапускает ее. Если состояние FATAL ERROR, то работа абстрактной программы завершается
        супервизором. Все изменения состояний должны сопровождаться соответствующими сообщениями в консоли.
        Использовать конструкции с wait/notify */

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
