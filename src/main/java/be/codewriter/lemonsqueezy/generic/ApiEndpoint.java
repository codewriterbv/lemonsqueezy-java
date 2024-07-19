package be.codewriter.lemonsqueezy.generic;

public enum ApiEndpoint {
    STORES("stores");

    private final String location;

    ApiEndpoint(String location) {
        this.location = location;
    }

    public String getApiEndpoint() {
        return "https://api.lemonsqueezy.com/v1/" + location;
    }
}
