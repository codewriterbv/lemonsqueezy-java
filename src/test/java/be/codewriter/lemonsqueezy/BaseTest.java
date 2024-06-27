package be.codewriter.lemonsqueezy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public BaseTest() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    protected String loadJson(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(getClass().getResource(file).getPath())), StandardCharsets.UTF_8);
    }
}
