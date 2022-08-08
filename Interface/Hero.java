package Interface;

public class Hero {
    private MoveStrategy strategy;
    private int x, y;

    public Hero() {
        this.strategy = new Walk();
        x = 0;
        y = 0;
    }

    public void move(int x, int y) {
        if (this.x == x && this.y == y) {
            System.out.println("Hero already here");
            return;
        }
        System.out.println("Hero ");
        strategy.move();
        System.out.println(" from " + this.x + " " + this.y + " on " + x + " " + y);
        this.x = x;
        this.y = y;
    }

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }
}
