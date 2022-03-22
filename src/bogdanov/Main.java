package bogdanov;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String snakeCase;
            StringBuilder camelCase;
            final String arrow = "\t-->\t";
            final String exit = "exit";
            final String underscore = "_";

            while (true) {

                snakeCase = scanner.nextLine();

                if (snakeCase.isEmpty()) {
                    continue;
                }

                if (exit.equalsIgnoreCase(snakeCase)) {
                    break;
                }

                try {
                    camelCase = new StringBuilder(snakeCase + arrow);

                    String[] splitted = snakeCase.split(underscore);
                    camelCase.append(splitted[0].toLowerCase(Locale.ROOT));
                    for (int i = 1; i < splitted.length; i++) {
                        camelCase.append(upLeading(splitted[i]));
                    }

                    System.out.println(camelCase);
                } catch (Exception e) {
                    System.out.println(e.getClass().getSimpleName());
                }

            }

        }

    }

    private static String upLeading(String str) {
        return str.isEmpty()
                ? str
                :
                str.substring(0, 1).toUpperCase(Locale.ROOT)
                        + (str.length() == 1 ? "" : str.substring(1).toLowerCase(Locale.ROOT));
    }

}
