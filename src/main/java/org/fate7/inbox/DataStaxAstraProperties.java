package org.fate7.inbox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;

@Configuration
@ConfigurationProperties(prefix = "datastax.astra")
@Data
public class DataStaxAstraProperties {

    private File secureConnectBundle;

}
