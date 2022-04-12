package lab3;

import lab3.animals.*;
import java.util.LinkedList;

public class Queue<T> {
    private final int maxSize;
    private LinkedList<T> queue;

    public Queue(int size) {
        maxSize = size;
        queue = new LinkedList<>();
    }

    private Queue(LinkedList<T> list) {
        maxSize = list.size();
        queue = list;
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public boolean isFull() {
        return queue.size() == maxSize;
    }

    public void add(T newElement) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        queue.add(newElement);
    }

    public T get() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T first = queue.get(0);
        queue.remove(first);
        return first;
    }

    public static Queue<? extends Chordal> produce(int n) {
        Chordal[] allTypesOfChordals = {
                new BrownBears(), new RedFox(), new WhiteBears(), new Dog(), new Wolf(), new CommonFox(),
                new MalayBear(), new Baribal(), new HimalayanBear(), new CommonBear(), new AsiaBear()
        };
        Queue<Chordal> producedQueue = new Queue<>(n);
        for (int i = 0; i < n; ++i) {
            producedQueue.add(allTypesOfChordals[(int) (Math.random() * (allTypesOfChordals.length))]);
        }
        return producedQueue;
    }

    public static void consume(Queue<? extends Chordal> producedQueue) {
        if (producedQueue == null || producedQueue.isEmpty()) {
            return;
        }
        LinkedList<Chordal> listOfBrownBears = new LinkedList<>();
        LinkedList<Chordal> listOfHimalayanBears = new LinkedList<>();
        for (Chordal object : producedQueue.queue) {
            if (isParent(object, BrownBears.class)) {
                listOfBrownBears.add(object);
            }
            if (isParent(object, HimalayanBear.class)) {
                listOfHimalayanBears.add(object);
            }
        }
        Queue<? super BrownBears> parentQueueOfBrownBears = new Queue<>(listOfBrownBears);
        Queue<? super HimalayanBear> parentQueueOfHimalayanBears = new Queue<>(listOfHimalayanBears);

        System.out.println("Parents of brown bears:");
        parentQueueOfBrownBears.print();
        System.out.println("\nParents of himalayan bears");
        parentQueueOfHimalayanBears.print();
    }

    public void print() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        }
        for (T t : queue) {
            System.out.println(t.getClass());
        }
    }

    private static boolean isParent(Chordal parentObject, Class<? extends Chordal> childClass) {
        if (parentObject == null) {
            return false;
        }
        Class<?> currentClass = childClass;
        while (currentClass != Chordal.class) {
            if (currentClass == parentObject.getClass()) {
                return true;
            }
            currentClass = currentClass.getSuperclass();
        }
        return false;
    }
}
