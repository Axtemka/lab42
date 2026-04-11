/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author temdo
 */
@JacksonXmlRootElement(localName = "mission")
public class MissionDTO {
    private String missionId;
    private String date;
    private String location;
    private String outcome;
    private Integer damageCost;
    private CurseDTO curse;
    //private List<SorcererDTO> sorcerers;
    //private List<TechniqueDTO> techniques;
    @JsonAnySetter
    private LinkedHashMap<String, Object> extras = new LinkedHashMap<>();
    
    public MissionDTO(){}

    public MissionDTO(String missionId, String date, String location, String outcome, Integer damageCost, CurseDTO curse, List<SorcererDTO> sorcerers, List<TechniqueDTO> techniques) {
        this.missionId = missionId;
        this.date = date;
        this.location = location;
        this.outcome = outcome;
        this.damageCost = damageCost;
        this.curse = curse;
        //this.sorcerers = sorcerers;
        //this.techniques = techniques;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Integer getDamageCost() {
        return damageCost;
    }

    public void setDamageCost(Integer damageCost) {
        this.damageCost = damageCost;
    }

    public CurseDTO getCurse() {
        return curse;
    }

    public void setCurse(CurseDTO curse) {
        this.curse = curse;
    }

//    public List<SorcererDTO> getSorcerers() {
//        return sorcerers;
//    }
//
//    public void setSorcerers(List<SorcererDTO> sorcerers) {
//        this.sorcerers = sorcerers;
//    }
//
//    public List<TechniqueDTO> getTechniques() {
//        return techniques;
//    }
//
//    public void setTechniques(List<TechniqueDTO> techniques) {
//        this.techniques = techniques;
//    }
    
    @JsonAnyGetter
    public LinkedHashMap<String, Object> getExtras() {
        return extras;
    }

    @JsonAnySetter
    public void addExtra(String key, Object value) {
        extras.put(key, value);
    }
}
