package be.codewriter.lemonsqueezy.store;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/stores#the-store-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store extends Data {
    private StoreAttributes attributes;

    public Store() {
        // For JSON parsing
        setType(DataType.STORES);
    }

    public StoreAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(StoreAttributes attributes) {
        this.attributes = attributes;
    }
}
