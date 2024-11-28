package com.hydropowerplant.waterlevel.dao.relationship;

import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelActionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelActionRelationshipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicePowerLevelActionRelationshipDao extends JpaRepository<DevicePowerLevelActionRelationship, DevicePowerLevelActionRelationshipKey> {
}
