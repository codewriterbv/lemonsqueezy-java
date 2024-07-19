package be.codewriter.lemonsqueezy.generic;

import be.codewriter.lemonsqueezy.webhook.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {
    @JsonProperty("test_mode")
    private Boolean testMode;
    @JsonProperty("event_name")
    private EventType type;
    @JsonProperty("webhook_id")
    private UUID id;
    @JsonProperty("page")
    private Page page;

    public Meta() {
        // For JSON parsing
    }

    public Boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(Boolean testMode) {
        this.testMode = testMode;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
