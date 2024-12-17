package com.hydropowerplant.waterlevel.businesslayer.service.action;

import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.dataaccesslayer.repository.action.SmsActionDao;
import com.hydropowerplant.waterlevel.entity.action.Action;
import com.hydropowerplant.waterlevel.entity.action.SmsAction;
import org.springframework.stereotype.Service;

@Service(SmsActionBoImpl.SERVICE_NAME)
public class SmsActionBoImpl implements ActionBo, SmsActionBo {

    public static final String SERVICE_NAME = "smsAction";

    private final SmsActionDao smsActionDao;

    public SmsActionBoImpl(SmsActionDao smsActionDao) {
        this.smsActionDao = smsActionDao;
    }


    @Override
    public void saveSmsAction(SmsAction smsAction) {
        smsActionDao.save(smsAction);
    }

    @Override
    public <T extends Action, S extends Event> void start(T action, S event) {
        //TODO
    }
    
}
