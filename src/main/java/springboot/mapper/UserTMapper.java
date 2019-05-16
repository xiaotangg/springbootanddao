package springboot.mapper;


import org.springframework.stereotype.Component;
import springboot.dao.UserT;
import springboot.dao.UserTExample;

import java.util.List;

@Component(value = "userTMapper")
public interface UserTMapper {
    int countByExample(UserTExample example);

    int deleteByExample(UserTExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserT record);

    int insertSelective(UserT record);

    List<UserT> selectByExample(UserTExample example);

    UserT selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(UserT record);

    int updateByPrimaryKey(UserT record);
}