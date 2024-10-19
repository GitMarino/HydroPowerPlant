package com.hydropowerplant.waterlevel.repository;

import com.hydropowerplant.waterlevel.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
