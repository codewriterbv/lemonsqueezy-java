package be.codewriter.lemonsqueezy.customer;

import be.codewriter.lemonsqueezy.generic.JsonApi;
import be.codewriter.lemonsqueezy.generic.Links;
import be.codewriter.lemonsqueezy.generic.Meta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://docs.lemonsqueezy.com/api/customers#the-customer-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponse {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("jsonapi")
    private JsonApi jsonApi;
    @JsonProperty("data")
    private Customer customer;

    public CustomerResponse() {
        // For JSON parsing
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public JsonApi getJsonApi() {
        return jsonApi;
    }

    public void setJsonApi(JsonApi jsonApi) {
        this.jsonApi = jsonApi;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
