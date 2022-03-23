package bogdanov;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleApp {

    private static final String COMMAND_EXIT = "/exit";
    private static final String COMMAND_CLEAR = "/clear";
    private static final String EMPTY_STRING = "";
    private static final String CMD_CLEAR = "\033[H\033[2J";

    public static int run() {
        try (Reader reader = new ReaderSystemIn()) {

            Converter converter = new Converter();

            String snakeCase;
            loop: while (true) {

                switch (snakeCase = reader.nextLine().toLowerCase(Locale.ROOT)) {
                    case EMPTY_STRING:
                        continue;

                    case COMMAND_EXIT:
                        break loop;

                    case COMMAND_CLEAR:
                        System.out.print(CMD_CLEAR);
                        System.out.flush();
                        break;

                    default:
                        System.out.println(converter.snakeCaseToCamelCase(snakeCase));
                }

            }

        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
            return 1;
        }

        return 0;
    }

}
