package com.hydropowerplant.waterlevel.repository;

import com.hydropowerplant.waterlevel.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioDao extends JpaRepository<Scenario, Integer> {
}
