package com.hydropowerplant.waterlevel.repository;

import com.hydropowerplant.waterlevel.database.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDao extends JpaRepository<Status, Integer> {
}
