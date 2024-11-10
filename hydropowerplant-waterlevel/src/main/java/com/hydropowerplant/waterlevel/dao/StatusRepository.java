package com.hydropowerplant.waterlevel.dao;

import com.hydropowerplant.waterlevel.database.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
