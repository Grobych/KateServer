package server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

//    @Autowired
//    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}