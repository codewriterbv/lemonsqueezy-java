package be.codewriter.lemonsqueezy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected final ObjectMapper objectMapper = new ObjectMapper();
    protected final String API_BEARER_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5NGQ1OWNlZi1kYmI4LTRlYTUtYjE3OC1kMjU0MGZjZDY5MTkiLCJqdGkiOiI1NTU1ZjBjODEzOTk1YzQ0Y2Y2ZTE2MmJiZDg1NGMxZDg2MWE2YWVlMmI4OTJiMTVlMzJhN2Y1ZjI3YjQwNjI2NTU4OGZjZGFjMzI2ODRhNiIsImlhdCI6MTcyMTM5OTUzMS4wMDcyMTcsIm5iZiI6MTcyMTM5OTUzMS4wMDcyMTksImV4cCI6MjAzNjkzMjMzMC45ODIyNzYsInN1YiI6IjI0NzY3MzAiLCJzY29wZXMiOltdfQ.RY7fP_AxetzxzyEMMKQ4I5KCyBlaFaCgkj5qBehakuqeaP0n2xzTF-l0SgIWFlb4VxJaJx0i_bHA7VDaRVtGDGT-ASOB43K9eR07w4_Xid0RsS4f1sei7wVJfB9eAPobPplyJULQHbZJDjBBw_EwXWvyaGyuOlbGa07GbxAsPE1gr4MEtM0qXq5QCHuoMh8KZ_U4E8Dfxvfuta5V_2KR2Ui6kUWUz0Q_WEE9A8a2W1UIXoh8cjPS2NxkDI4xzUo3wGvpkrpGUMuNs8uY6X8gB8LPUv4mVoErfNI1K__rNfl3bxfnKpRDiJ3U6MdaJgDmk9MmQ7UkhdSzdSY7tdZIN9LyTAaFWit_hsQ1zbTLRIfCpFxTNMQOF-_fZpwEjC5hvNjzOk9RmBbWSpyioyN7sA9ggjTjb2xBlwgLFm3GVyXfkZpMoPcnYBvIU9nknNACo2T0KdeyTC13VCUDPZ1j0fNwY72X9PmWK36cPb2AR55kD5R-5CMm1qDLEL8YaEGC";


    public BaseTest() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")));
        objectMapper.registerModule(javaTimeModule);
    }

    protected String loadJson(String fileName) throws IOException {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new FileNotFoundException("Resource not found: " + fileName);
            }
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    protected String makePrettyJson(Object o) throws JsonProcessingException {
        ObjectWriter prettyPrinter = objectMapper.writerWithDefaultPrettyPrinter();
        return prettyPrinter.writeValueAsString(o);
    }
}
