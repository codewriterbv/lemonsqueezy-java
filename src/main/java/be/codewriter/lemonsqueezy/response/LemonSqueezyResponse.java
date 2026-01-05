package be.codewriter.lemonsqueezy.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import be.codewriter.lemonsqueezy.generic.JsonApi;
import be.codewriter.lemonsqueezy.generic.Links;
import be.codewriter.lemonsqueezy.generic.Meta;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LemonSqueezyResponse<T> {
    private Meta meta;
    private JsonApi jsonapi;
    private Links links;
    private List<T> data;

    // Getters and Setters
    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public JsonApi getJsonapi() {
        return jsonapi;
    }

    public void setJsonapi(JsonApi jsonapi) {
        this.jsonapi = jsonapi;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
