package ro.esolacad.msge.storeservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
@RefreshScope
@Slf4j
public class TestResource {

    @Value("${config-test:default}")
    private String testConfig;

    @GetMapping
    public String test() {
        return testConfig;
    }
}
