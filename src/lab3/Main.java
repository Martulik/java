package lab3;

import lab3.animals.*;
import static lab3.Queue.*;

public class Main {
    public static void main(String[] args) {
        Queue<? extends Chordal> producedQueue = produce(20);
        System.out.println("Produced Queue:");
        producedQueue.print();

        System.out.println("\nConsumed Queue:");
        consume(producedQueue);
    }
}
