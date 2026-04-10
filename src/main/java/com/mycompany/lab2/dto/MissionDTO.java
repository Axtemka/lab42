/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.w3c.dom.Element;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author temdo
 */
public class MissionDTO {
    @XmlElement
    private String missionId;
    @XmlElement
    private String date;
    @XmlElement
    private String location;
    @XmlElement
    private String outcome;
    @XmlElement
    private Integer damageCost;
    @XmlElement(name = "curse")
    private CurseDTO curse;
    @XmlElementWrapper(name = "sorcerers")
    @XmlElement(name = "sorcerer")
    private List<SorcererDTO> sorcerers;
    @XmlElementWrapper(name = "techniques")
    @XmlElement(name = "technique")
    private List<TechniqueDTO> techniques;
    
    @XmlAnyElement // JAXB положит сюда все теги, которых нет выше (note, comment, message и др.)
    @JsonIgnore    // Jackson не должен сериализовать этот служебный список
    private List<Element> rawElements = new ArrayList<>();
    
    @XmlAnyElement
    private LinkedHashMap<String, Object> extras = new LinkedHashMap<>();
    
    public MissionDTO(){}

    public MissionDTO(String missionId, String date, String location, String outcome, Integer damageCost, CurseDTO curse, List<SorcererDTO> sorcerers, List<TechniqueDTO> techniques) {
        this.missionId = missionId;
        this.date = date;
        this.location = location;
        this.outcome = outcome;
        this.damageCost = damageCost;
        this.curse = curse;
        this.sorcerers = sorcerers;
        this.techniques = techniques;
    }
//    
//    public void fillExtras() {
//        for (Element el : rawElements) {
//            System.out.println(el.getLocalName() + " " + el.getTextContent());
//        }
//        for (Element el : rawElements) {
//            this.extras.put(el.getLocalName(), el.getTextContent());
//        }
//    }

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

    public List<SorcererDTO> getSorcerers() {
        return sorcerers;
    }

    public void setSorcerers(List<SorcererDTO> sorcerers) {
        this.sorcerers = sorcerers;
    }

    public List<TechniqueDTO> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<TechniqueDTO> techniques) {
        this.techniques = techniques;
    }
    
    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        return extras;
    }

    @JsonAnySetter
    public void addExtra(String key, Object value) {
        extras.put(key, value);
    }
}
