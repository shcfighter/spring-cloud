package cloud.simple.service;

import cloud.simple.model.User;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by za-wangshenhua on 2017/5/28.
 */
@Component
public class FallBackFeignService implements FeignUserService {

    private static final Logger LOGGER = LogManager.getLogger(FallBackFeignService.class);
    @Override
    public List<User> findByIdFeign() {
        List<User> resultList = Lists.newArrayList();
        User user = new User();
        user.setUserName("调用错误");
        resultList.add(user);
        LOGGER.error("调用fallback。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        return resultList;
    }

    @Override
    public User getUser(int id) {
        User user = new User();
        user.setUserName("调用错误");
        LOGGER.error("调用fallback。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        return user;
    }


}
