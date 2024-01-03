package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "sky.txcos")
@Data
public class TXCosProperties {
    private String secretId;
    private String secretKey;
    private  String region;
    private String bucketName;
}
