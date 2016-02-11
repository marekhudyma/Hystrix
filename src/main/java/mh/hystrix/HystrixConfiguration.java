package mh.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:hystrix.properties")
class HystrixConfiguration {

    @Autowired
    private HystrixBootstrapService hystrixBootstrapService;

    /**
     * to expose stream endpoint
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
    }

    /**
     * to expose properties, @PropertySource is needed
     */
    @PostConstruct
    public void init() throws Exception {
        hystrixBootstrapService.bootstrapHystrix();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
