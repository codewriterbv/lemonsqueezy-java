# lemonsqueezy-java

[![GitHub license](https://img.shields.io/github/license/NdoleStudio/lemonsqueezy-go?color=brightgreen)](https://github.com/NdoleStudio/lemonsqueezy-go/blob/master/LICENSE)

This package provides a Java SDK for the Lemon Squeezy API, as documented
on [lemonsqueezy.com/api](https://docs.lemonsqueezy.com/api).

## Provided Functionality

### General Guidelines

This library helps you to parse data received from the Lemon Squeezy API. Parsing between JSON and Java objects is done
with the Jackson library. Because of the datetime format used in the JSONs, you need to use the JavaTimeModule().
Initiate the ObjectMapper like this:

```java
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.registerModule(new JavaTimeModule());
```

### Implemented Objects and Methods

**THIS IS WORK-IN-PROGRESS...**

#### ApiRequest

Uses `java.net.http.HttpClient` to request data from the Lemon Squeezy API.

```java
HttpResponse<String> response = ApiRequest.get(ApiEndpoint.STORES, API_BEARER_TOKEN);
StoreListResponse list = objectMapper.readValue(response.body(), StoreListResponse.class);
System.out.println("Number of shops: " + list.getStores().size());
for (Store store : list.getStores()) {
    System.out.println("ID " + store.getId() + ": " + store.getAttributes().getName());
}
```

#### Data Objects

* **Checkout**
    ```java
    Checkout checkout = objectMapper.readValue(checkoutJson, Checkout.class);
    CheckoutAttributes attr = checkout.getAttributes();
    ```
* **Customer**
    ```java
    Customer user = objectMapper.readValue(customerJson, Customer.class);
    CustomerAttributes attr = user.getAttributes();
    ```
* **License**
    ```java
    LicenseKey licenseKey = objectMapper.readValue(licenseKeyJson, LicenseKey.class);
    LicenseKeyAttributes attr = licenseKey.getAttributes();
    ```
* **Order**
    ```java
    Order order = objectMapper.readValue(orderJson, Order.class);
    OrderAttributes attr = order.getAttributes();
    ```
* **Store**
    ```java
    Store store = objectMapper.readValue(storeJson, Store.class);
    StoreAttributes attr = store.getAttributes();
    ```
* **Subscription**
    ```java
    Subscription subscription = objectMapper.readValue(subscriptionJson, Subscription.class);
    SubscriptionAttributes attr = subscription.getAttributes();
    ```
* **User**
    ```java
    User user = objectMapper.readValue(userJson, User.class);
    UserAttributes attr = user.getAttributes();
    assertAll(
        () -> assertEquals("Darlene Daugherty", attr.getName(), "User attributes name should be equal"),
        () -> assertEquals("gernser@yahoo.com", attr.getEmail(), "User attributes email should be equal"),
        ...
    );
    ```
* **Webhooks**, example implementation with a Spring Boot Restcontroller:
    ```java
    @RestController
    @RequestMapping("/api/callback")
    @PermitAll
    public class CallbackController {
      private final ObjectMapper objectMapper = new ObjectMapper();
    
      public CallbackController() {
         // This is needed to parse the timestamps provided in JSON format by Lemon Squeezy
         objectMapper.registerModule(new JavaTimeModule());
      }
    
      @PostMapping()
      public void webhook(@RequestBody String message) {
        // 1. Authenticate the webhook request from Lemon Squeezy using the `X-Signature` header
    
        // 2. Parse the payload if the request is authenticated
        WebhookMessage webhookMessage = objectMapper.readValue(message), WebhookMessage.class)
    
        // 3. Do something with the webhookMessage, depending on our use-case
      }
    }
    ```

## Using this Library in your Project

### From Maven Repository

Released versions are available via the [Maven repository on central.sonatype.com/artifact/be.codewriter/lemonsqueezy-java](https://central.sonatype.com/artifact/be.codewriter/lemonsqueezy-java):

```xml
<dependency>
    <groupId>be.codewriter</groupId>
    <artifactId>lemonsqueezy-java</artifactId>
    <version>${lemonsqueezy.version}</version>
</dependency>
```


### From GitHub Repository

A new artifact is created with GitHub Actions and is available from [GitHub Packages on github.com/codewriterbv/lemonsqueezy-java/packages/2189280](https://github.com/codewriterbv/lemonsqueezy-java/packages/2189280)

1. Add dependency to your `pom.xml`:
    ```xml
    <dependency>
      <groupId>be.codewriter</groupId>
      <artifactId>lemonsqueezy-java</artifactId>
      <version>${lemonsqueezy.version}</version>
    </dependency> 
    ```
2. Add repository to your `pom.xml`:
    ```xml
    <repositories>
        <repository>
            <id>github</id>
            <name>GitHub Maven Packages</name>
            <url>https://maven.pkg.github.com/codewriterbv/lemonsqueezy-java</url>
            <!-- Add the following only if you want to use snapshot versions -->
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
    ```
3. The GitHub repository requires credentials to get packages
   as [described here](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages).
   Add a GitHub token to your `settings.xml` in the `.m2` directory:
    ```xml
    <settings>
      ...
      <servers>
        ...
        <server>
            <id>github</id>
            <username>YOUR_USER_NAME</username>
            <password>YOUR_TOKEN</password>
        </server>
      </servers>
    </settings>
    ```

#### Detailed Info

The library is published on GitHub Repository following these tutorials:

* https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry
* https://docs.github.com/en/actions/publishing-packages/publishing-java-packages-with-maven