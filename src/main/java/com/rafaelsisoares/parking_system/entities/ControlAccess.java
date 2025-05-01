package com.rafaelsisoares.parking_system.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "control_access")
public class ControlAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String plate;
    private Boolean position = false;

    public ControlAccess() {};

    public ControlAccess(Long id, String name, String plate, Boolean position) {
        this.id = id;
        this.name = name;
        this.plate = plate;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Boolean getPosition() {
        return position;
    }

    public void setPosition(Boolean position) {
        this.position = position;
    }
}
