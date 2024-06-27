package be.codewriter.lemonsqueezy.store;

import be.codewriter.lemonsqueezy.generic.JsonApi;
import be.codewriter.lemonsqueezy.generic.Links;
import be.codewriter.lemonsqueezy.generic.Meta;
import be.codewriter.lemonsqueezy.webhook.data.Relationships;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://docs.lemonsqueezy.com/api/users#the-user-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreResponse {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("jsonapi")
    private JsonApi jsonApi;
    @JsonProperty("data")
    private Store store;
    @JsonProperty("relationships")
    private Relationships relationships;

    public StoreResponse() {
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }
}
