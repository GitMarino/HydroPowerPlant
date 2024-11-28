package com.hydropowerplant.waterlevel.dao.action;

import com.hydropowerplant.waterlevel.entity.action.PowerLevelAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerLevelActionDao extends JpaRepository<PowerLevelAction, Integer> {
}
