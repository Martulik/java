package lab4;

public class ClassWithAnnotationMethods {
    @NumberOfRepeats(1)
    private void one() {
        System.out.print("1");
    }

    @NumberOfRepeats(2)
    private void two() {
        System.out.print("2");
    }

    @NumberOfRepeats(3)
    private void three() {
        System.out.print("3");
    }

    @NumberOfRepeats(4)
    private void four() {
        System.out.print("4");
    }

    private void notAnnotationMethod() {
        System.out.println("notAnnotationMethod");
    }
}

