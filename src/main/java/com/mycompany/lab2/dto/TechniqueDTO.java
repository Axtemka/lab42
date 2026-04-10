/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.dto;

import jakarta.xml.bind.annotation.XmlElement;

/**
 *
 * @author temdo
 */
public class TechniqueDTO {
    @XmlElement
    private String name;
    @XmlElement
    private String type;
    @XmlElement
    private String owner;
    @XmlElement
    private Integer damage;

    public TechniqueDTO(){}

    public TechniqueDTO(String name, String type, String owner, Integer damage) {
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.damage = damage;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
    
    public void info(){
        System.out.println("----name: " + getName());
        System.out.println("----type: " + getType());
        System.out.println("----owner: " + getOwner());
        System.out.println("----damage: " + getDamage());
    }
}
