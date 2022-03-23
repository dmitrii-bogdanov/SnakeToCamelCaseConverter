package bogdanov;

import java.util.Locale;
import java.util.Scanner;

public class Converter {

    private static final String UNDERSCORE = "_";
    private static final String ARROW = "\t-->\t";

    public String snakeCaseToCamelCase(String snakeCase) {
        StringBuilder camelCase = new StringBuilder(snakeCase + ARROW);

        String[] splitted = snakeCase.split(UNDERSCORE);
        camelCase.append(splitted[0].toLowerCase(Locale.ROOT));

        for (int i = 1; i < splitted.length; i++) {
            camelCase.append(upLeading(splitted[i]));
        }

        return camelCase.toString();
    }

    private String upLeading(String str) {
        return str.isEmpty()
                ? str
                :
                str.substring(0, 1).toUpperCase(Locale.ROOT)
                        + (str.length() == 1 ? "" : str.substring(1).toLowerCase(Locale.ROOT));
    }

}
