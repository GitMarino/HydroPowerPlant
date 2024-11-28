package com.hydropowerplant.waterlevel.businesslogic.bo.action;

import com.hydropowerplant.waterlevel.businesslogic.object.event.Event;
import com.hydropowerplant.waterlevel.entity.action.Action;

import java.util.Optional;

public interface ActionBo {

    <T extends Action, S extends Event> void start(T action, Optional<S> event);

}
