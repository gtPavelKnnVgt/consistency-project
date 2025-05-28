package demo.claims.fw.spring;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages =  {
        "demo.claims.adapter.*"
})
public class FeignConf {
}
