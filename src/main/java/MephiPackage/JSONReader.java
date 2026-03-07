package MephiPackage;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JSONReader implements Reader{

    File file;
    public JSONReader(File file){
        this.file =
    }

    @Override
    public Mission extract() {
        ObjectMapper mapper = new ObjectMapper();
        Mission mission = mapper.readValue(file,Mission.class);
    }
}
