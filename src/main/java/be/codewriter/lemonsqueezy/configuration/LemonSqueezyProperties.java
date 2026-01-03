package be.codewriter.lemonsqueezy.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "lemonsqueezy.api")
public class LemonSqueezyProperties {
    /**
     * The API key used for authenticating requests to the Lemon Squeezy API.
     * This key is configured via application properties with the prefix "lemonsqueezy.api".
     * If no key is provided, a default key value of "default-key" is used.
     */
    private String apiKey = "default-key";

    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
