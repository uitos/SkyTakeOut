package com.sky.config;

import com.sky.properties.TXCosProperties;
import com.sky.utils.TXCosUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 功能描述: 配置类，用于创建TXCosUtil
 */
@Configuration
@Slf4j
public class CosConfiguration {

    @Bean
    public TXCosUtil txCosUtil(TXCosProperties txCosProperties){
        log.info("开始创建阿里云文件上传工具类对象：{}",txCosProperties);
        return new TXCosUtil(txCosProperties.getSecretId(),
                txCosProperties.getSecretKey(),
                txCosProperties.getRegion(),
                txCosProperties.getBucketName());
    }

}
