package gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;

import gateway.limiter.HostAddrKeyResolver;
import gateway.limiter.UriKeyResolver;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GatewayLimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run( GatewayLimiterApplication.class, args );
    }
    //方法1----http://localhost:8081/
  //  @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
    //方法2----http://localhost:8081/
    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }
    
    //方法3----http://localhost:8081/?user=123
//  @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}
