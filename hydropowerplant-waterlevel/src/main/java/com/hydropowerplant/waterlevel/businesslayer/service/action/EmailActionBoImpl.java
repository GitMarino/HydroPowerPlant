package com.hydropowerplant.waterlevel.businesslayer.service.action;

import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.businesslayer.object.property.MailProperties;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.action.EmailActionDao;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.EmailAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger log = LoggerFactory.getLogger(EmailActionBoImpl.class);

    @Override
    public void saveEmailAction(EmailAction emailAction) {
        EmailAction emailActionDB = emailActionDao.save(emailAction);
        log.info("Email action created with id [{}]", emailActionDB.getId());
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
        if (action instanceof EmailAction emailAction) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailProperties.getUsername());
            message.setTo(emailAction.getAddress());
            message.setSubject(emailAction.getSubject());
            message.setText(emailAction.getText());
            try {
                javaEmailSender.send(message);
                log.info("Email sent to [{}]", emailAction.getAddress());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
    
}
