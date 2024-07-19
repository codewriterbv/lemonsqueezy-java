package be.codewriter.lemonsqueezy.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Urls {
    @JsonProperty("receipt")
    private String receipt;
    @JsonProperty("customer_portal")
    private String customerPortal;

    public Urls() {
        // For JSON parsing
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getCustomerPortal() {
        return customerPortal;
    }

    public void setCustomerPortal(String customerPortal) {
        this.customerPortal = customerPortal;
    }
}
