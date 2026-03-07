package MephiPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLReader implements Reader{

    File file;
    public XMLReader(File file) throws IOException {
        this.file = file;
    }

    @Override
    public Mission extract(File file) throws IOException {
        XmlMapper mapper = new XmlMapper();
        Mission mission = mapper.readValue(file,Mission.class);
        return mission;
    }
}
