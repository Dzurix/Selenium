package end2end.podaci;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class DataReader {

  public List<HashMap<String, String>> getJSONdataToMap() throws IOException {
    //reading JSON to String
    String jsonContent = FileUtils.readFileToString(
      new File(
        System.getProperty("user.dir") +
        "src//test//java//end2end//podaci//podaciJSON.json"
      ),
      StandardCharsets.UTF_8
    );
    //String to HashMap using Jackson Databind (from MVN repo)
    ObjectMapper mapper = new ObjectMapper();

    List<HashMap<String, String>> data = mapper.readValue(
      jsonContent,
      new TypeReference<List<HashMap<String, String>>>() {}
    );
    return data;
  }
}
