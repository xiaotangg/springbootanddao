package springboot.service.impl;

import org.springframework.stereotype.Service;
import springboot.dao.UserT;
import springboot.mapper.UserTMapper;
import springboot.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl  implements UserService {


    @Resource
    private UserTMapper userTMapper;


    @Override
    public UserT getUserByPrimaryKey(Integer id) {
        return userTMapper.selectByPrimaryKey(id);
    }
}
