package cloud.simple.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by za-wangshenhua on 2017/7/27.
 */
@RestController
@RequestMapping("/sleuth")
public class SleuthController {

    private static final Logger LOGGER = LogManager.getLogger(SleuthController.class);
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://cloud-sleuth-service/sleuth/index", String.class);
    }
}
