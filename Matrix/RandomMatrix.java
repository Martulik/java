package Matrix;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class RandomMatrix {
    private double[][] matrix;

    public RandomMatrix(int size) {
        matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) ((Math.random() * (2 * size) + 1)) - size;
            }
        }
    }

    public void print(OutputStream out) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String str = String.format("  %.1f  ", matrix[i][j]);
                out.write(str.getBytes());
            }
            out.write(("\n").getBytes());
        }
        out.write(("\n").getBytes());
    }

    public void rotate(int degrees) {
        int numberOfTurns = degrees / 90;
        for (int k = 0; k < numberOfTurns; k++) {
            matrix = rotateOnes();
        }
    }

    public double[][] rotateOnes() {
        double[][] rotate = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotate[matrix.length - 1 - j][i] = matrix[i][j];
            }
        }
        return rotate;
    }

    public void doSumAndDivisionEntireMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                doSumAndDivision(i, j);
            }
        }
    }

    public void doSumAndDivision(int row, int col) {
        double sum = getSumOfNeighboring(row, col);
        try {
            matrix[row][col] = divide(matrix[row][col], sum);
        } catch (DivisionByZeroException e) {
            System.out.print("To avoid division by 0 you must replace element (row = " + (row + 1));
            if (col != matrix.length - 1) {
                System.out.println(" column = " + (col + 2) + ") with a number != " + matrix[row][col + 1]);
                setNewElement(row, col + 1);
            } else {
                System.out.println(" column = " + col + ") with a number != 0.0");
                setNewElement(row, col - 1);
            }
            doSumAndDivision(row, col);
        }
    }

    private double getSumOfNeighboring(int row, int col) {
        return (col == 0) ? (matrix[row][1]) :
                ((col == matrix.length - 1) ? (matrix[row][col - 1]) : (matrix[row][col - 1] + matrix[row][col + 1]));
    }

    public double divide(double denominator, double divisor) throws DivisionByZeroException {
        if (divisor == 0) {
            throw new DivisionByZeroException();
        }
        return denominator / divisor;
    }

    private void setNewElement(int row, int col) {
        System.out.println("Enter new Element");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextDouble()) {
            System.err.println("it must be a double, try again");
            in.nextLine();
        }
        double newElement = in.nextDouble();
        matrix[row][col] = newElement;
    }
}
