package com.hydropowerplant.waterlevel.dao.relationship;

import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelActionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelActionRelationshipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevicePowerLevelActionRelationshipDao extends JpaRepository<DevicePowerLevelActionRelationship, DevicePowerLevelActionRelationshipKey> {

    List<String> findIdDeviceSerialByIdPowerLevelActionId(Integer powerLevelActionId);

}
