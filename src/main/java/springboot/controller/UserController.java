package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.dao.UserT;
import springboot.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getuser")
    @ResponseBody
    public UserT getUserByPrimaryKey(){
        return userService.getUserByPrimaryKey(1001);
    }

    @RequestMapping("/index")
    public String userUpdate(){
       return "index.html";
    }

    @PutMapping("/doSomething")
    @ResponseBody
    public String userUpdate(String id){
        System.out.println(id);
       return id;
    }

}
