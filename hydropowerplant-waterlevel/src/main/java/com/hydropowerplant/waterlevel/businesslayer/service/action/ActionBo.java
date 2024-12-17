package com.hydropowerplant.waterlevel.businesslayer.service.action;

import com.hydropowerplant.waterlevel.businesslayer.object.event.Event;
import com.hydropowerplant.waterlevel.entity.action.Action;

public interface ActionBo {

    <T extends Action, S extends Event> void start(T action, S event);

}
