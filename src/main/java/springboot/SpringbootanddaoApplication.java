package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = "springboot")
@MapperScan("springboot.mapper")
@EnableTransactionManagement
public class SpringbootanddaoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootanddaoApplication.class, args);
    }

}
