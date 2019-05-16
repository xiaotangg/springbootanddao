package springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUser(){
        System.out.println(userService.getUserByPrimaryKey(1001));
    }






}
