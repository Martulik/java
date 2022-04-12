package lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hero hero = new Hero();

        System.out.println("Write x");
        do {
            while (!in.hasNextInt()) {
                System.err.println("wrong input, write x again");
                in.nextLine();
            }
            int x = in.nextInt();

            System.out.println("Write y");
            while (!in.hasNextInt()) {
                System.err.println("wrong input, write y again");
                in.nextLine();
            }
            int y = in.nextInt();

            System.out.println("Write strategy");
            MoveStrategy strategy = getStrategy();
            while (strategy == null) {
                System.err.println("strategy not found, try again");
                strategy = getStrategy();
            }

            hero.setStrategy(strategy);
            hero.move(x, y);

            System.out.println("Write x");
        } while (in.hasNext());

        in.close();
    }

    private static MoveStrategy getStrategy() {
        MoveStrategy strategy = null;
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line.equalsIgnoreCase("fly")) {
            strategy = new Fly();
        } else if (line.equalsIgnoreCase("walk")) {
            strategy = new Walk();
        } else if (line.equalsIgnoreCase("rideHorse")) {
            strategy = new RideHorse();
        }
        return strategy;
    }
}

