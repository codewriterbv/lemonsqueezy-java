package be.codewriter.lemonsqueezy.store;

import be.codewriter.lemonsqueezy.generic.JsonApi;
import be.codewriter.lemonsqueezy.generic.Links;
import be.codewriter.lemonsqueezy.generic.Meta;
import be.codewriter.lemonsqueezy.relationship.Relationships;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * https://docs.lemonsqueezy.com/api/users#the-user-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreListResponse {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("jsonapi")
    private JsonApi jsonApi;
    @JsonProperty("data")
    private List<Store> stores;
    @JsonProperty("relationships")
    private Relationships relationships;

    public StoreListResponse() {
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

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }
}
