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
public class SorcererDTO {
    @XmlElement
    private String name;
    @XmlElement
    private String rank;
    
    public SorcererDTO(){}
    

    public SorcererDTO(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
