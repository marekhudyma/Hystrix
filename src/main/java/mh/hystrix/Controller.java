package mh.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/")
public class Controller {

    private AtomicBoolean networkProblems = new AtomicBoolean(false);

    @RequestMapping(value="networkProblems", method= RequestMethod.GET)
    public Boolean reverte() {
        networkProblems.set(!networkProblems.get());
        return networkProblems.get();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getRequest() {

        return new CommandHttpCall("http://www.google.com", networkProblems).execute();
    }
}
