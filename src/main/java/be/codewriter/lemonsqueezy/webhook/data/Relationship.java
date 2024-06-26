package be.codewriter.lemonsqueezy.webhook.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Relationship {
    @JsonProperty("links")
    private Links links;

    public Relationship() {
        // For JSON parsing
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
