package be.codewriter.lemonsqueezy.variant;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.generic.DataType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VariantTest extends BaseTest {

    @Test
    void shouldParseVariantItemResponse() throws IOException {
        final VariantResponse response = objectMapper.readValue(loadJson("lemonsqueezy/variant/variant_item_response.json"), VariantResponse.class);
        final Variant variantData = response.getData();
        final VariantAttributes attr = variantData.getAttributes();
        assertAll(
                // Meta
                () -> assertEquals(true, response.getMeta().getTestMode(), "Response Meta testMd should be equal"),
                // Json API
                () -> assertEquals("1.0", response.getJsonApi().getVersion(), "Response Json API version should be equal"),
                // Links
                () -> assertEquals("https://api.lemonsqueezy.com/v1/variants/1187357", response.getLinks().getSelf(), "Response Links should not be equal"),
                // Data
                () -> assertEquals(DataType.VARIANTS, variantData.getType(), "Variant type should be equal"),
                () -> assertEquals("1183333", variantData.getId(), "Variant ID should be equal"),
                    // Data Attributes
                    () -> assertNotNull(attr, "Variant attributes should not be null"),
                    () -> assertEquals("Default", attr.getName(), "Variant attributes name should be equal"),
                    () -> assertEquals("some description", attr.getDescription(), "Variant description should be equal"),
                    () -> assertEquals(49900, attr.getPrice(), "Variant price should be equal"),
                    () -> assertEquals("pending", attr.getStatus(), "Variant status should be equal"),
                    () -> assertEquals(LocalDateTime.parse("2022-12-01T13:01:07"), attr.getCreatedAt(), "User attributes created at should be equal"),
                    () -> assertEquals(LocalDateTime.parse("2022-12-01T13:01:07"), attr.getUpdatedAt(), "User attributes updated at should be equal")
        );
    }
}
