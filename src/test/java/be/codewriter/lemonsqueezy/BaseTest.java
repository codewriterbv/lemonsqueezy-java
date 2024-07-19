package be.codewriter.lemonsqueezy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public BaseTest() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")));
        objectMapper.registerModule(javaTimeModule);
    }

    protected String loadJson(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(getClass().getResource(file).getPath())), StandardCharsets.UTF_8);
    }

    protected String makePrettyJson(Object o) throws JsonProcessingException {
        ObjectWriter prettyPrinter = objectMapper.writerWithDefaultPrettyPrinter();
        return prettyPrinter.writeValueAsString(o);
    }
}
