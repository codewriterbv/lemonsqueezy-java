package be.codewriter.lemonsqueezy.user;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.generic.DataType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest extends BaseTest {

    @Test
    void shouldParseUser() throws IOException {
        User user = objectMapper.readValue(loadJson("/lemonsqueezy/user/user.json"), User.class);
        UserAttributes attr = user.getAttributes();
        assertAll(
                () -> assertEquals(DataType.USERS, user.getType(), "User type should be equal"),
                () -> assertEquals("1", user.getId(), "User ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "User attributes should not be null"),
                () -> assertEquals("Darlene Daugherty", attr.getName(), "User attributes name should be equal"),
                () -> assertEquals("gernser@yahoo.com", attr.getEmail(), "User attributes email should be equal"),
                () -> assertEquals("#898FA9", attr.getColor(), "User attributes color should be equal"),
                () -> assertEquals("https://www.gravatar.com/avatar/1ace5b3965c59dbcd1db79d85da75048?d=blank", attr.getAvatarUrl(), "User attributes avatar URL should be equal"),
                () -> assertFalse(attr.getHasCustomAvatar(), "User attributes has customer avatar should be false"),
                () -> assertEquals(LocalDateTime.parse("2021-05-24T14:08:31.000000"), attr.getCreatedAt(), "User attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-08-26T13:24:54.000000"), attr.getUpdatedAt(), "User attributes updated at should be equal")
        );
    }

    @Test
    void shouldParseUserResponse() throws IOException {
        UserResponse response = objectMapper.readValue(loadJson("/lemonsqueezy/user/user_response.json"), UserResponse.class);
        UserAttributes attr = response.getUser().getAttributes();
        assertAll(
                // Meta
                () -> assertTrue(response.getMeta().getTestMode(), "Response test mode should be true"),
                // Json API
                () -> assertEquals("1.0", response.getJsonApi().getVersion(), "Response Json API version should be equal"),
                // User
                () -> assertEquals(DataType.USERS, response.getUser().getType(), "User type should be equal"),
                () -> assertEquals("1", response.getUser().getId(), "User ID should be equal"),
                // Data Attributes
                () -> assertNotNull(attr, "User attributes should not be null"),
                () -> assertEquals("Darlene Daugherty", attr.getName(), "User attributes name should be equal"),
                () -> assertEquals("gernser@yahoo.com", attr.getEmail(), "User attributes email should be equal"),
                () -> assertEquals("#898FA9", attr.getColor(), "User attributes color should be equal"),
                () -> assertEquals("https://www.gravatar.com/avatar/1ace5b3965c59dbcd1db79d85da75048?d=blank", attr.getAvatarUrl(), "User attributes avatar URL should be equal"),
                () -> assertFalse(attr.getHasCustomAvatar(), "User attributes has customer avatar should be false"),
                () -> assertEquals(LocalDateTime.parse("2021-05-24T14:08:31.000000"), attr.getCreatedAt(), "User attributes created at should be equal"),
                () -> assertEquals(LocalDateTime.parse("2021-08-26T13:24:54.000000"), attr.getUpdatedAt(), "User attributes updated at should be equal"),
                // Links
                () -> assertEquals("https://api.lemonsqueezy.com/v1/users/1", response.getLinks().getSelf(), "Response links self should be equal"),
                () -> assertEquals("https://api.lemonsqueezy.com/v1/users/1", response.getUser().getLinks().getSelf(), "User links self should be equal")
        );
    }
}
