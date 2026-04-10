/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.data;

import java.util.LinkedHashMap;

/**
 *
 * @author temdo
 */
public class Mission {
    private String missionId;
    private String date;
    private String location;
    private Outcome outcome;
    private Curse curse;
    private LinkedHashMap<String, Object> extras = new LinkedHashMap<String, Object>();

    public String getMissionId() {
        return missionId;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public Curse getCurse() {
        return curse;
    }

    public LinkedHashMap<String, Object> getExtras() {
        return extras;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public void setCurse(Curse curse) {
        this.curse = curse;
    }

    public void setExtras(LinkedHashMap<String, Object> extras) {
        this.extras = extras;
    }    
    
}
