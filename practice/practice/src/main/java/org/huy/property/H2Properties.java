package org.huy.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.datasource.h2")
@Data
public class H2Properties {
    private String url;
    private String user;
    private String password;
    private Integer maxPoolSize;
    private Integer minimumIdle;
}
