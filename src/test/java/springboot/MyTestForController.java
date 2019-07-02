package springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springboot.controller.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=springboot.SpringbootanddaoApplication.class)
@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath*:**application.yml"})
public class MyTestForController {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
//        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }


    @Test
    public void testMyController() throws Exception {
        // 测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/User/getuser");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());

    }






}
