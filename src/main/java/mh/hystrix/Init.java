package mh.hystrix;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        HystrixCodaHaleMetricsPublisher metricsPublisher = new HystrixCodaHaleMetricsPublisher(bootstrap.getMetricRegistry());
//        HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
    }
}
