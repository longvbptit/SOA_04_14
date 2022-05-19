package RentOxy;

import java.util.List;

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
    public void sendMessage(@RequestBody List<String> noti) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("huongdichvu4.14@gmail.com");
        message.setTo(noti.get(0));
        message.setSubject(noti.get(1));
        message.setText(noti.get(2));
        emailSender.send(message);
    }
}
