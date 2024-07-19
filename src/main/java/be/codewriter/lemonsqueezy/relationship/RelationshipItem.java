package be.codewriter.lemonsqueezy.relationship;

import be.codewriter.lemonsqueezy.generic.Links;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelationshipItem {
    @JsonProperty("links")
    private Links links;
    @JsonProperty("data")
    private RelationshipData data;

    public RelationshipItem() {
        // For JSON parsing
    }

    public RelationshipItem(RelationshipData data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
