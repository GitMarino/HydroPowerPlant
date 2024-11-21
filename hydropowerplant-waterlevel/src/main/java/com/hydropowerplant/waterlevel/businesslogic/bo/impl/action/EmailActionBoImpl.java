package com.hydropowerplant.waterlevel.businesslogic.bo.impl.action;

import com.hydropowerplant.waterlevel.businesslogic.bo.ActionBo;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.EmailAction;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service(EmailActionBoImpl.SERVICE_NAME)
public class EmailActionBoImpl implements ActionBo {

    public static final String SERVICE_NAME = "emailAction";

    private final JavaMailSender emailSender;

    public EmailActionBoImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    

    public <T extends Action> void start(T action) {
        if (action instanceof EmailAction emailAction) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("icmarino6108@gmail.com");
            message.setTo(emailAction.getAddress());
            message.setSubject(emailAction.getSubject());
            message.setText(emailAction.getText());
            emailSender.send(message);
        }
    }
}
