package in.dev.ggs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class GenerateQrCodeApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/QR_Generate");
        SpringApplication.run( GenerateQrCodeApplication.class, args );
    }

    @GetMapping
    public String sayGreeting() {
        return "Hello Lunar!";
    }

}
