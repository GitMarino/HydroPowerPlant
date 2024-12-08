package com.hydropowerplant.waterlevel.businesslogic.bo.action;

import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.dao.action.EmailActionDao;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.EmailAction;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service(EmailActionBoImpl.SERVICE_NAME)
public class EmailActionBoImpl implements ActionBo, EmailActionBo {

    public static final String SERVICE_NAME = "emailAction";

    private final EmailActionDao emailActionDao;

    private final JavaMailSender emailSender;

    public EmailActionBoImpl(EmailActionDao emailActionDao, JavaMailSender emailSender) {
        this.emailActionDao = emailActionDao;
        this.emailSender = emailSender;
    }


    @Override
    public void saveEmailAction(EmailAction emailAction) {
        emailActionDao.save(emailAction);
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
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
