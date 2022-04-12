package lab7;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Queue {

    static class Reader implements Runnable {
        BlockingQueue<String> queue;

        Reader(BlockingQueue<String> queueNew) {
            queue = queueNew;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    doRead();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void doRead() throws InterruptedException {
            String thing = queue.take();
            System.out.println(Thread.currentThread().getName() + " take " + thing);
            Utils.pause(3000);
        }
    }

    static class Writer implements Runnable {
        Random random = new Random();
        BlockingQueue<String> queue;

        Writer(BlockingQueue<String> queueNew) {
            queue = queueNew;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    doPut();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void doPut() throws InterruptedException {
            String thing = String.valueOf(random.nextInt(50));
            queue.put(thing);
            System.out.println(Thread.currentThread().getName() + " put " + thing);
            Utils.pause(3000);
        }
    }

}
