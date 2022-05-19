package ultility.controller;

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
public class MailController {
	@Autowired
    private JavaMailSender emailSender;

    @PostMapping("/mail")
    public void sendMessage(@RequestBody List<String> list) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dohoanglong8@gmail.com");
        message.setTo(list.get(0));
        message.setSubject(list.get(1));
        message.setText(list.get(2));
        emailSender.send(message);
    }


}
