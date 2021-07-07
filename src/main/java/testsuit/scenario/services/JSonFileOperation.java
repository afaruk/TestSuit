package testsuit.scenario.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSonFileOperation {

    public <T> T createJsonObject(String filePathName,  Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePathName), valueType);
    }

    public void printJsonObject(Object jsonObject) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        System.out.println(prettyStaff);
    }
}
