package bogdanov;

import java.io.Closeable;

public interface Reader extends Closeable {

    String nextLine();

}
