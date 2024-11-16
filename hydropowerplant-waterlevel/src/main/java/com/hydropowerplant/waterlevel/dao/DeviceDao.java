package com.hydropowerplant.waterlevel.dao;

import com.hydropowerplant.waterlevel.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao extends JpaRepository<Device, String> {
}
