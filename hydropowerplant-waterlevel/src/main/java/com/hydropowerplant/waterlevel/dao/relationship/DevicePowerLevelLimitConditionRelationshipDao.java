package com.hydropowerplant.waterlevel.dao.relationship;

import com.hydropowerplant.waterlevel.entity.relationship.DevicePowerLevelLimitConditionRelationship;
import com.hydropowerplant.waterlevel.entity.relationship.key.DevicePowerLevelLimitConditionRelationshipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicePowerLevelLimitConditionRelationshipDao extends JpaRepository<DevicePowerLevelLimitConditionRelationship, DevicePowerLevelLimitConditionRelationshipKey> {
}