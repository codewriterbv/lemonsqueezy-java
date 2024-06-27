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

### Implemented Objects

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

Not available yet...

### From GitHub Repository

The published versions are available here: https://github.com/codewriterbv/lemonsqueezy-java/packages/2189280

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