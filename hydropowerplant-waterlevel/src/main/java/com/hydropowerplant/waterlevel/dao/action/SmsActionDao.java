package com.hydropowerplant.waterlevel.dao.action;

import com.hydropowerplant.waterlevel.entity.action.SmsAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsActionDao extends JpaRepository<SmsAction, Integer> {
}
