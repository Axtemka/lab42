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
public class CurseDTO {
    @XmlElement
    private String name;
    @XmlElement
    private String threatLevel;
    
    public CurseDTO(){}

    public CurseDTO(String name, String threatLevel) {
        this.name = name;
        this.threatLevel = threatLevel;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(String threatLevel) {
        this.threatLevel = threatLevel;
    }

}
