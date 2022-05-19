package RentOxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NotifyController {
	@Autowired
    private JavaMailSender emailSender;
	
//	@Autowired
//    private JavaMailSender javaMailSender;
	
//	private static final Logger logger = Logger.getLogger(SendToEmailService.class);

    @PostMapping("/notify")
    public void sendMessage(@RequestBody String noti) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vubaolong2000@gmail.com");
        message.setTo("dohoanglong8@gmail.com");
        message.setSubject("ahihi");
        message.setText(noti);
        System.out.println("Minh rat chao ban!");
        emailSender.send(message);
    }
}
