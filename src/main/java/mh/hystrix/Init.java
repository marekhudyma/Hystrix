package mh.hystrix;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//to expose mbean "Config-com.netflix.config.jmx"
//        AbstractConfiguration configuration = ConfigurationManager.getConfigInstance();
//        ConfigJMXManager.registerConfigMbean(configuration);
    }

}
