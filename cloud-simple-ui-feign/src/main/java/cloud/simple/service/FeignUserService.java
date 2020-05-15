package cloud.simple.service;

import cloud.simple.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by za-wangshenhua on 2017/5/28.
 */
@FeignClient(name = "CLOUD-SIMPLE-SERVICE", fallback = FallBackFeignService.class)
public interface FeignUserService {

    @RequestMapping(value = "getUserList")
    List<User> findByIdFeign();

    @RequestMapping(value = "/getUser/{id}")
    User getUser(@PathVariable(value = "id") Integer id);
}
