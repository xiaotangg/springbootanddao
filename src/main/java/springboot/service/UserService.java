package springboot.service;

import springboot.dao.UserT;

public interface UserService {
    UserT getUserByPrimaryKey(Integer integer);
}
