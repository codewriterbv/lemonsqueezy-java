package be.codewriter.lemonsqueezy.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAddress {
    @JsonProperty("country")
    private String country;
    @JsonProperty("zip")
    private String zip;

    public BillingAddress() {
        // For JSON parsing
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
