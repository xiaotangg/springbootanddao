package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "springboot")
@MapperScan("springboot.mapper")
public class SpringbootanddaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootanddaoApplication.class, args);
	}

}
