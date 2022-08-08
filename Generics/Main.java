package Generics;

import Generics.animals.*;
import static Generics.Queue.*;

public class Main {
    public static void main(String[] args) {
        Queue<? extends Chordal> producedQueue = produce(20);
        System.out.println("Produced Queue:");
        producedQueue.print();

        System.out.println("\nConsumed Queue:");
        consume(producedQueue);
    }
}
