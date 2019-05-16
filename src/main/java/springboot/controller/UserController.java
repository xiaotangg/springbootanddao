package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.dao.UserT;
import springboot.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getuser")
    @ResponseBody
    public UserT getUserByPrimaryKey(){
        return userService.getUserByPrimaryKey(1001);
    }


}
