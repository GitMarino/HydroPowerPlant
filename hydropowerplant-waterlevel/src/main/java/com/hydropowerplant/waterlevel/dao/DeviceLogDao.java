package com.hydropowerplant.waterlevel.dao;

import com.hydropowerplant.waterlevel.entity.DeviceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceLogDao extends JpaRepository<DeviceLog, Integer> {
}