import com.example.model.Email;
import com.example.util.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example")
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private MailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }



    public void run(String... args) throws Exception {
        Email email = new Email();
        email.setFrom("franciscoantoniogarciaquintana@gmail.com");
        email.setTo("tony_16_fagq@hotmail.com");
        email.setSubject("This is a test mail");
        email.setMessageText("This is a sample text message.");
        emailService.sendEmail(email);
        System.out.println("email enviado!!!..");
    }
}
