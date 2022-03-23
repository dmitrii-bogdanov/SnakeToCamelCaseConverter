package bogdanov;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleApp {

    private static final String COMMAND_EXIT = "/exit";
    private static final String COMMAND_CLEAR = "/clear";
    private static final String EMPTY_STRING = "";

    private static final ProcessBuilder PROCESS_CLEAR =  new ProcessBuilder("cmd", "/c", "cls");

    public static int run() {
        try (Reader reader = new ReaderSystemIn()) {

            Converter converter = new Converter();

            String snakeCase;
            loop: while (true) {

                switch (snakeCase = reader.nextLine().toLowerCase(Locale.ROOT)) {

                    case EMPTY_STRING:
                        break;

                    case COMMAND_EXIT:
                        break loop;

                    case COMMAND_CLEAR:
                        clear();
                        break;

                    default:
                        System.out.println(converter.snakeCaseToCamelCase(snakeCase));
                }

            }

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
            return 1;
        }

        return 0;
    }

    private static void clear() throws IOException, InterruptedException {
        PROCESS_CLEAR.inheritIO().start().waitFor();
    }

}
