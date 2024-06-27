package be.codewriter.lemonsqueezy.webhook.item;

import be.codewriter.lemonsqueezy.generic.Links;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelationshipItem {
    @JsonProperty("links")
    private Links links;

    public RelationshipItem() {
        // For JSON parsing
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
