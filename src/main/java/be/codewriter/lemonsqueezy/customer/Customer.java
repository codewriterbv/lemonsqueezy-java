package be.codewriter.lemonsqueezy.customer;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/api/customers#the-customer-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer extends Data {
    private CustomerAttributes attributes;

    public Customer() {
        // For JSON parsing
        setType(DataType.CUSTOMERS);
    }

    public CustomerAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CustomerAttributes attributes) {
        this.attributes = attributes;
    }
}
