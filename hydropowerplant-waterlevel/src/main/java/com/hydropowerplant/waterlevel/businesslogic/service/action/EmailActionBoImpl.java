package com.hydropowerplant.waterlevel.businesslogic.service.action;

import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.businesslogic.property.MailProperties;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.EmailAction;
import com.hydropowerplant.waterlevel.repository.action.EmailActionDao;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service(EmailActionBoImpl.SERVICE_NAME)
public class EmailActionBoImpl implements ActionBo, EmailActionBo {

    public static final String SERVICE_NAME = "emailAction";

    private final EmailActionDao emailActionDao;

    private final JavaMailSender javaEmailSender;

    private final MailProperties mailProperties;

    public EmailActionBoImpl(EmailActionDao emailActionDao, JavaMailSender javaEmailSender, MailProperties mailProperties) {
        this.emailActionDao = emailActionDao;
        this.javaEmailSender = javaEmailSender;
        this.mailProperties = mailProperties;
    }

    @Override
    public void saveEmailAction(EmailAction emailAction) {
        emailActionDao.save(emailAction);
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
        if (action instanceof EmailAction emailAction) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailProperties.getUsername());
            message.setTo(emailAction.getAddress());
            message.setSubject(emailAction.getSubject());
            message.setText(emailAction.getText());
            javaEmailSender.send(message);
        }
    }
    
}
