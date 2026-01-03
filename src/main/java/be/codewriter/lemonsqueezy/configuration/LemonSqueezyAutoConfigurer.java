package be.codewriter.lemonsqueezy.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(LemonSqueezyProperties.class)
public class LemonSqueezyAutoConfigurer {

    @Bean
    @ConditionalOnMissingBean
    public LemonSqueezyClient lemonSqueezyClient(final LemonSqueezyProperties properties) {
        // This is where you pass the API key from properties to your client
        return new LemonSqueezyClient(properties.getApiKey());
    }
}
