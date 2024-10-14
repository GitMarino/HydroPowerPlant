package com.hydropowerplant.water_level.repository;

import com.hydropowerplant.water_level.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDAO extends JpaRepository<Device, Integer> {
}
