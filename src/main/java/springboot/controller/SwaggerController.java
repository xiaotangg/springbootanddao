package springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/swagger", description = "测试swagger的控制层")
@RestController
@RequestMapping(value = "/swagger")
public class SwaggerController {

//    @Autowired
//    private UserService userService;

//    @ApiOperation(value = "根据用户id获取用户信息")
//    @PostMapping("/getSwaggerConfig")
//    public UserT getUserByUserId(@RequestBody @ApiParam(value = "需要的参数(用户id)",required = true) SwaggerParam swaggerParam){
//        return userService.getUserByPrimaryKey(1001);
//    }


}
