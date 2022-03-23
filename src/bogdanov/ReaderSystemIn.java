package bogdanov;

import java.util.Scanner;

public class ReaderSystemIn implements Reader{

    private final Scanner scanner;

    public ReaderSystemIn() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }

}
