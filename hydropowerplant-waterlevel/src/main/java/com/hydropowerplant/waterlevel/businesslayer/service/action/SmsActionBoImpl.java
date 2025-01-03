package com.hydropowerplant.waterlevel.businesslayer.service.action;

import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.businesslayer.object.property.SmsProperties;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.action.SmsActionDao;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.SmsAction;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(SmsActionBoImpl.SERVICE_NAME)
public class SmsActionBoImpl implements ActionBo, SmsActionBo {

    public static final String SERVICE_NAME = "smsAction";

    private final SmsActionDao smsActionDao;

    private final SmsProperties smsProperties;

    public SmsActionBoImpl(SmsActionDao smsActionDao, SmsProperties smsProperties) {
        this.smsActionDao = smsActionDao;
        this.smsProperties = smsProperties;
        Twilio.init(smsProperties.getUsername(), smsProperties.getPassword());
    }

    private static final Logger log = LoggerFactory.getLogger(SmsActionBoImpl.class);

    @Override
    public void saveSmsAction(SmsAction smsAction) {
        SmsAction smsActionDB = smsActionDao.save(smsAction);
        log.info("Sms action created with id [{}]", smsActionDB.getId());
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
        if (action instanceof SmsAction smsAction) {
            try {
                Message.creator(
                                new PhoneNumber(smsAction.getPhoneNumber()),
                                new PhoneNumber(smsProperties.getNumber()),
                                smsAction.getText())
                        .create();
                log.info("SMS sent to [{}]", smsAction.getPhoneNumber());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
    
}
