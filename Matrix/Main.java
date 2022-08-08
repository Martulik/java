package Matrix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String INPUT_FILENAME = "/Users/martha/Desktop/java/labs_3530904_00004/labs/src/lab2/resources/size.txt";
    private static final String OUTPUT_FILENAME = "/Users/martha/Desktop/java/labs_3530904_00004/labs/src/lab2/resources/matrix.txt";
    private static final int MAX_SIZE = 1_000_000;

    public static void main(String[] args) {
        try {
            int size = readSize();
            RandomMatrix matrix = new RandomMatrix(size);
            doTask(matrix);
        } catch (MyFileNotFoundException | TooLargeSizeException e) {
            e.printStackTrace(System.err);
        }
    }

    private static void doTask(RandomMatrix matrix) {
        if (matrix == null) {
            return;
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILENAME, true)) {
            matrix.print(fileOutputStream);
            matrix.print(System.out);
            for (int i = 1; i < 4; i++) {
                matrix.rotate(i * 90);
                matrix.doSumAndDivisionEntireMatrix();
                matrix.print(fileOutputStream);
                matrix.print(System.out);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }


    private static int readSize() throws MyFileNotFoundException, TooLargeSizeException {
        try (Scanner scanner = new Scanner(new FileInputStream(INPUT_FILENAME))) {
            int n = scanner.nextInt();
            if (n > MAX_SIZE) {
                throw new TooLargeSizeException();
            }
            return n;
        } catch (FileNotFoundException e) {
            throw new MyFileNotFoundException();
        }
    }

}
