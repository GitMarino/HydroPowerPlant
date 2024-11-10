package com.hydropowerplant.waterlevel.dao;

import com.hydropowerplant.waterlevel.database.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    Optional<Device> findBySerial(String serial);

}
