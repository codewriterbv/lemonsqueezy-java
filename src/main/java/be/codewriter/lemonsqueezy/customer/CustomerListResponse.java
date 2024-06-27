package be.codewriter.lemonsqueezy.customer;

import be.codewriter.lemonsqueezy.generic.JsonApi;
import be.codewriter.lemonsqueezy.generic.Links;
import be.codewriter.lemonsqueezy.generic.Meta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * https://docs.lemonsqueezy.com/api/customers#the-customer-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerListResponse {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("jsonapi")
    private JsonApi jsonApi;
    @JsonProperty("data")
    private List<Customer> customers;

    public CustomerListResponse() {
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
