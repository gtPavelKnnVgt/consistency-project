package demo.claims.fw.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "demo.claims.domain")
public class JpaConfig {
}
