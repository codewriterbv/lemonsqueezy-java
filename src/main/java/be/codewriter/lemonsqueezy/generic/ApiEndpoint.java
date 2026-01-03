package be.codewriter.lemonsqueezy.generic;

public enum ApiEndpoint {
    STORES("stores"),
    PRODUCTS("products"),
    VARIANTS("variants"),
    ORDERS("orders"),
    SUBSCRIPTIONS("subscriptions");

    private final String location;

    ApiEndpoint(String location) {
        this.location = location;
    }

    /**
     * @return The full API URL for the specific resource
     */
    public String getApiEndpoint() {
        return "https://api.lemonsqueezy.com/v1/" + location;
    }
}
