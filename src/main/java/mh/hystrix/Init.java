package mh.hystrix;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.jmx.ConfigJMXManager;
import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * to expose mbean "Config-com.netflix.config.jmx"
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AbstractConfiguration configuration = ConfigurationManager.getConfigInstance();
        ConfigJMXManager.registerConfigMbean(configuration);
    }

}
