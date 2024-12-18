package com.hydropowerplant.waterlevel.businesslayer.service.action;

import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.action.SmsActionDao;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.SmsAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(SmsActionBoImpl.SERVICE_NAME)
public class SmsActionBoImpl implements ActionBo, SmsActionBo {

    public static final String SERVICE_NAME = "smsAction";

    private final SmsActionDao smsActionDao;

    public SmsActionBoImpl(SmsActionDao smsActionDao) {
        this.smsActionDao = smsActionDao;
    }

    private static final Logger log = LoggerFactory.getLogger(SmsActionBoImpl.class);

    @Override
    public void saveSmsAction(SmsAction smsAction) {
        SmsAction smsActionDB = smsActionDao.save(smsAction);
        log.info("Sms action {} with id={} created", smsActionDB.getName(), smsActionDB.getId());
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
        if (action instanceof SmsAction smsAction) {
            //TODO
            log.info("SMS sent to {}", smsAction.getPhoneNumber());
        }
    }
    
}
