package springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Controller
@RequestMapping("/Student")
public class StudentController {

//    @Autowired
//    private UserService userService;

//    @RequestMapping("/getuser")
//    @ResponseBody
//    public UserT getUserByPrimaryKey(){
//        return userService.getUserByPrimaryKey(1001);
//    }

    @RequestMapping("/index")
    public String userUpdate(){
       return "index";
    }

    @PutMapping("/doSomething")
    @ResponseBody
    public String userUpdate(String id){
        System.out.println(id);
        return id;
    }


    //使用NIO进行文件下载
    @PostMapping("/download")
    public void download( HttpServletResponse response){
        try {
            File fileA = ResourceUtils.getFile("classpath:a.txt");
            response.setContentType("multipart/form-data");
            response.addHeader("Content-Disposition", "attachment;filename=" + "a.txt");// 设置文件名
            response.setContentLength((int) fileA.length());

            FileChannel channel = new FileInputStream(fileA).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            byte[] byteArray=new byte[1024];
            int nRead,nGet;
            //while中的条件其实是从通道往缓冲区写数据
            while ((nRead = channel.read(buffer)) != -1) {
                if (nRead == 0) {
                    continue;
                }
                //这里开始是从缓冲区读取数据，因为上面往缓冲区写的时候导致属性变化，需要重置变量数值
//                buffer.flip();  //这个方法等价于下面的position和limit的结合
                buffer.position(0);
                buffer.limit(nRead);
                while (buffer.hasRemaining()) {
                    nGet = Math.min(buffer.remaining(), 1024);
                    // read bytes from disk
                    buffer.get(byteArray, 0, nGet);
                    // write bytes to output
                    response.getOutputStream().write(byteArray);
                }
                buffer.clear();
            }

            buffer.clear();
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
