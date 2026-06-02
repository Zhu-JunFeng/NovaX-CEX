package com.novax.cex.persistence.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.novax.cex")
public class PersistenceConfiguration {
    // 统一扫描各服务基础设施层下的 Mapper，保持 DDD 下领域层与持久化实现分离。
}
