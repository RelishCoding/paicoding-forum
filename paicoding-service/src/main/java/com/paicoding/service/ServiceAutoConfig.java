package com.paicoding.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.paicoding.service")
@MapperScan(basePackages = {
        "com.paicoding.service.article.repository.mapper",
        "com.paicoding.service.user.repository.mapper",
        "com.paicoding.service.comment.repository.mapper",
        "com.paicoding.service.config.repository.mapper",
        "com.paicoding.service.statistics.repository.mapper",
        "com.paicoding.service.notify.repository.mapper",
})
public class ServiceAutoConfig {
}
