package com.hydropowerplant.waterlevel.businesslogic.bo.action;

import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.entity.action.Action;

public interface ActionBo {

    <T extends Action, S extends Event> void start(T action, S event);

}
