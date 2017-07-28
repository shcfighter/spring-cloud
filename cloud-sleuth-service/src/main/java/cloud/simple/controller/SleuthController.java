package cloud.simple.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by za-wangshenhua on 2017/7/27.
 */
@RestController
@RequestMapping("/sleuth")
public class SleuthController {

    private static final Logger LOGGER = LogManager.getLogger(SleuthController.class);

    @GetMapping("/index")
    public String index(){
        return "被调用";
    }
}
