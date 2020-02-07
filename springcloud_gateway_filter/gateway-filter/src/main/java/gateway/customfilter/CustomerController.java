package gateway.customfilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController(value = "/customer")
public class CustomerController {
	private static final Log logger = LogFactory.getLog(CustomerController.class);
	
	@RequestMapping(value = "/print")
	@HystrixCommand(fallbackMethod = "hiError")
	public String print() {
		logger.info( "print123" );
		return "print123";
	}
    public String hiError() {
        return "sorry,error!";
    }
}
