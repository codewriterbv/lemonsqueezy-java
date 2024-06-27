package be.codewriter.lemonsqueezy.webhook;

import be.codewriter.lemonsqueezy.generic.Data;
import be.codewriter.lemonsqueezy.generic.Meta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://docs.lemonsqueezy.com/help/webhooks#webhook-requests
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookMessage {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("data")
    private Data data;

    public WebhookMessage() {
        // For JSON parsing
    }

    public WebhookMessage(Meta meta, Data data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
