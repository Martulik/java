package Interface;

public class Walk implements MoveStrategy {
    @Override
    public void move() {
        System.out.print("walk");
    }
}

