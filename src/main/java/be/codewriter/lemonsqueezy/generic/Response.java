package be.codewriter.lemonsqueezy.generic;

import be.codewriter.lemonsqueezy.relationship.Relationships;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://docs.lemonsqueezy.com/api
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("jsonapi")
    private JsonApi jsonApi;
    @JsonProperty("relationships")
    private Relationships relationships;
    @JsonProperty("included")
    private Data included;

    public Response() {
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

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public Data getIncluded() {
        return included;
    }

    public void setIncluded(Data included) {
        this.included = included;
    }
}
