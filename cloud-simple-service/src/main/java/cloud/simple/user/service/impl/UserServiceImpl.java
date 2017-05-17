package cloud.simple.user.service.impl;

import cloud.simple.user.dao.UserMapper;
import cloud.simple.user.model.User;
import cloud.simple.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by za-wangshenhua on 2017/5/11.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean insertUser(User user) {
        int rowNum =  userMapper.insertSelective(user);
        /*if(rowNum > 0){
            throw new RuntimeException("插入异常！");
        }*/

        return false;
    }
}
