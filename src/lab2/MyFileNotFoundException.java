package lab2;

import java.io.FileNotFoundException;

public class MyFileNotFoundException extends FileNotFoundException {
    MyFileNotFoundException() {
        super("The file does not exist");
    }
}
