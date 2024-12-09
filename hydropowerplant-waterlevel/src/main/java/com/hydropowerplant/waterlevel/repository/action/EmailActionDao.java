package com.hydropowerplant.waterlevel.repository.action;

import com.hydropowerplant.waterlevel.entity.action.EmailAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailActionDao extends JpaRepository<EmailAction, Integer> {
}
