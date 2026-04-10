/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.data;

/**
 *
 * @author temdo
 */
public class Technique {
    private String name;
    private Type type;
    private String owner;
    private Integer damage;

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getOwner() {
        return owner;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
