package com.test;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by za-wangshenhua on 2017/6/10.
 */
public class Test {
    public static void main(String[] args) {
    	// TODO Auto- ""generated method stub
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 9999999; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(i);
            user.setCardid(UUID.randomUUID().toString());
            user.setCreateDate(new Date());
            user.setLoginName(i + "fds");
            user.setMobile(i + "6456");
            user.setPassword(UUID.randomUUID().toString());
            user.setVersion(i + 0l);
            user.setUserName(i + "4365");
            list.add(user);
        }

    }

    private void springBeanTo(List<User> list){
        for (User u : list) {
            BeanUtils.copyProperties(u, User.class);
        }
    }
}
