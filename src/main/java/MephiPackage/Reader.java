package MephiPackage;

import java.io.File;
import java.io.IOException;

public interface Reader {

    public Mission extract(File file) throws IOException;

}
