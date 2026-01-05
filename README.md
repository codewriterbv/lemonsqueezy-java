# lemonsqueezy-java

[![GitHub license](https://img.shields.io/github/license/NdoleStudio/lemonsqueezy-go?color=brightgreen)](https://github.com/NdoleStudio/lemonsqueezy-go/blob/master/LICENSE)

This package provides a Java SDK for the Lemon Squeezy API, as documented
on [lemonsqueezy.com/api](https://docs.lemonsqueezy.com/api).

## General Guidelines

This library helps you to parse data received from the Lemon Squeezy API. Parsing between JSON and Java objects is done
with the Jackson library. Because of the datetime format used in the JSONs, you need to use the JavaTimeModule().
Initiate the ObjectMapper like this:

```java
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.registerModule(new JavaTimeModule());
```

## Implemented Objects and Methods

If you are missing a specific object or method, please open an [issue on GitHub](https://github.com/codewriterbv/lemonsqueezy-java/issues), or fork this project and submit a pull request with the missing functionality.

### ApiRequest

Uses `java.net.http.HttpClient` to request data from the Lemon Squeezy API.

```java
HttpResponse<String> response = ApiRequest.get(ApiEndpoint.STORES, API_BEARER_TOKEN);
StoreListResponse list = objectMapper.readValue(response.body(), StoreListResponse.class);
System.out.println("Number of shops: " + list.getStores().size());
for (Store store : list.getStores()) {
    System.out.println("ID " + store.getId() + ": " + store.getAttributes().getName());
}
```

### LemonSqueezyClient

#### Spring Boot Configuration

Add your Lemon Squeezy API key to your `application.properties` or `application.yml` file. The SDK will automatically detect this and initialize the LemonSqueezyClient bean for you.

```properties
lemonsqueezy.api-key=YOUR_API_KEY
```

#### Spring Boot Implementation Example

Once configured, you can inject the `LemonSqueezyClient` into any Spring-managed component. The example below demonstrates a REST controller handling both paginated lists and single resource lookups.

```java
package com.yourproject.controller;

import be.codewriter.lemonsqueezy.configuration.LemonSqueezyClient;
import be.codewriter.lemonsqueezy.generic.ApiEndpoint;
import be.codewriter.lemonsqueezy.response.LemonSqueezyResponse;
import be.codewriter.lemonsqueezy.variant.Variant;
import be.codewriter.lemonsqueezy.variant.VariantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/lemonsqueezy")
@RequiredArgsConstructor
public class LemonSqueezyController {

    private final LemonSqueezyClient client;

    /**
     * Fetch a paginated list of variants (plans)
     */
    @GetMapping("/list")
    public LemonSqueezyResponse<Variant> getList() throws IOException, InterruptedException {
        // Uses the built-in generic list handler
        return client.getList(ApiEndpoint.VARIANTS);
    }

    /**
     * Fetch specific details for a single variant by ID
     */
    @GetMapping("/item/{id}")
    public VariantResponse getItem(@PathVariable Long id) throws IOException, InterruptedException {
        // Maps the specific resource data to the VariantItem DTO
        return client.getItem(ApiEndpoint.VARIANTS, id, VariantResponse.class);
    }
}
```

### Data Objects

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

* **Variant**
    ```java
    Variant variant = objectMapper.readValue(variantJson, Variant.class);
    VariantAttributes attr = variant.getAttributes();
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

Released versions are available via the [Maven repository on central.sonatype.com/artifact/be.codewriter/lemonsqueezy-java](https://central.sonatype.com/artifact/be.codewriter/lemonsqueezy-java):

```xml
<dependency>
    <groupId>be.codewriter</groupId>
    <artifactId>lemonsqueezy-java</artifactId>
    <version>${lemonsqueezy.version}</version>
</dependency>
```

### Detailed Info

The library is published on GitHub Repository following these tutorials:

* https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry
* https://docs.github.com/en/actions/publishing-packages/publishing-java-packages-with-maven