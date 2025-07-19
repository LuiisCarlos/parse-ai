package dev.luisworks.parse_ai.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.cloudinary.Cloudinary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CloudinaryConfig {

    @Bean
    Cloudinary cloudinary(Environment env) {
        log.debug("Initializing Cloudinary context");

        String cloudName = env.getProperty("cloudinary.name");
        String apiKey = env.getProperty("cloudinary.api.key");
        String apiSecret = env.getProperty("cloudinary.api.secret");

        if ((Objects.isNull(cloudName) || cloudName.isEmpty()) ||
                (Objects.isNull(apiKey) || apiKey.isEmpty()) ||
                (Objects.isNull(apiSecret) || apiSecret.isEmpty()))
            throw new RuntimeException("Failed to load environments variables required for Cloudinary");

        Map<String, Object> config = new HashMap<>();

        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        config.put("secure", true);
        config.put("connect_timeout", 20000);

        return new Cloudinary(config);
    }

}
