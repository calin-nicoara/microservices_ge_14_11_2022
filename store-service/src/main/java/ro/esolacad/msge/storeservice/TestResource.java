package ro.esolacad.msge.storeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
@RefreshScope
public class TestResource {

    @Value("${config-test}")
    private String testConfig;

    @GetMapping
    public String test() {
        return testConfig;
    }
}
