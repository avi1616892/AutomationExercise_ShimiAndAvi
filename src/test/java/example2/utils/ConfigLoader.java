package example2.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigLoader {
    public static Config loadConfig(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), Config.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }
}
