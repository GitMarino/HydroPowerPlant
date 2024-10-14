package com.hydropowerplant.water_level.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = Device.TABLE_NAME)
public class Device {

    public static final String TABLE_NAME = "device";

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;
}
