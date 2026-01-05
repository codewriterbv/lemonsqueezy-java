package be.codewriter.lemonsqueezy.Response;

import be.codewriter.lemonsqueezy.BaseTest;
import be.codewriter.lemonsqueezy.generic.Page;
import be.codewriter.lemonsqueezy.response.LemonSqueezyResponse;
import be.codewriter.lemonsqueezy.variant.Variant;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LemonSqueezyResponseTest extends BaseTest {

    @Test
    void shouldParseVariantItemResponse() throws IOException {
        final TypeReference<LemonSqueezyResponse<Variant>> typeRef = new TypeReference<>() {};
        final LemonSqueezyResponse<Variant> response = objectMapper.readValue(loadJson("lemonsqueezy/variant/variant_list_response.json"), typeRef);
        final List<Variant> variantData = response.getData();
        final Page page = response.getMeta().getPage();
        assertAll(
                // Meta Page
                () -> assertEquals(1, page.getCurrentPage(), "Response Meta Page current should be equal"),
                () -> assertEquals(1, page.getFrom(), "Response Meta Page from should be equal"),
                () -> assertEquals(2, page.getLastPage(), "Response Meta Page last page should be equal"),
                () -> assertEquals(10, page.getPerPage(), "Response Meta Page per page should be equal"),
                () -> assertEquals(10, page.getTo(), "Response Meta Page to should be equal"),
                () -> assertEquals(11, page.getTotal(), "Response Meta Page total should be equal"),
                // Data
                () -> assertEquals(10, variantData.size(), "Variant type should be equal"),
                () -> assertNotNull(variantData.get(0).getAttributes(), "Variant attributes should not be null")
        );
    }
}
