package be.codewriter.lemonsqueezy.webhook;

import be.codewriter.lemonsqueezy.webhook.data.Data;
import be.codewriter.lemonsqueezy.webhook.meta.Meta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * https://docs.lemonsqueezy.com/help/webhooks#webhook-requests
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookMessage {
    private Meta meta;
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
