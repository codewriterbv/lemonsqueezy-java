package be.codewriter.lemonsqueezy.variant;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import be.codewriter.lemonsqueezy.order.OrderAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * https://docs.lemonsqueezy.com/api/variants/the-variant-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Variant extends Data {
    private VariantAttributes attributes;

    public Variant() {
        // For JSON parsing
        setType(DataType.VARIANTS);
    }

    public VariantAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(VariantAttributes attributes) {
        this.attributes = attributes;
    }
}
