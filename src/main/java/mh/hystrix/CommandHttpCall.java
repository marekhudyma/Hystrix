package mh.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommandHttpCall extends HystrixCommand<String> {

    private final String url;
    private final AtomicBoolean networkProblems;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CommandHttpCall.class);

    public CommandHttpCall(String url, AtomicBoolean networkProblems) {
        super(
                Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("hystrix.command.http"))
                      .andCommandKey(HystrixCommandKey.Factory.asKey("hystrix.command.http"))
                      .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hystrix.command.http"))
                      .andCommandPropertiesDefaults(
                              HystrixCommandProperties.Setter()
                                                      .withCircuitBreakerRequestVolumeThreshold(2)
                                                      .withCircuitBreakerSleepWindowInMilliseconds(60 * 1000)));
        this.url = url;
        this.networkProblems = networkProblems;
    }

    @Override
    protected String run() throws Exception {
        logger.info("Execution of Command: url={}, networkProblems={}", url, networkProblems);
        if(networkProblems.get()) {
            throw new IOException("Network problems");
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try(CloseableHttpResponse response = httpclient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        }
    }

}
