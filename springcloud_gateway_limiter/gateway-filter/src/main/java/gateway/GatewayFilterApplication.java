
package gateway;
import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import gateway.customfilter.RequestTimeFilter;
import gateway.customfilter.RequestTimeGatewayFilterFactory;
import gateway.customfilter.TokenFilter;

// tag::code[]
@SpringBootApplication
@RestController
public class GatewayFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class, args);
    }
    public String hiError() {
        return "sorry,error!";
    }
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayhi() {
        return "hi " ;
    }

    @RequestMapping(value = "/customer/123")
	@HystrixCommand(fallbackMethod = "hiError")
	public String print() {		
		return "print123";
	}
    @Bean
    //加入自定义过滤器工厂
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
  //@Bean
    //加入token
    public TokenFilter tokenFilter(){
           return new TokenFilter();
    }

}