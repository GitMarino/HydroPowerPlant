package com.hydropowerplant.waterlevel.dataaccesslayer.repository.action;

import com.hydropowerplant.waterlevel.entity.action.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActionDao extends JpaRepository<Action, Integer> {
}
