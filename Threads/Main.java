package Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("n = " + n);

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Queue.Writer writer = new Queue.Writer(queue);
        Queue.Reader reader = new Queue.Reader(queue);

        for (int i = 0; i < n; i++) {
            new Thread(writer, "writer-" + i).start();
            new Thread(reader, "reader-" + i).start();
        }
    }

}
