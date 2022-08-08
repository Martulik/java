package Matrix;

import java.io.FileNotFoundException;

public class MyFileNotFoundException extends FileNotFoundException {
    MyFileNotFoundException() {
        super("The file does not exist");
    }
}
