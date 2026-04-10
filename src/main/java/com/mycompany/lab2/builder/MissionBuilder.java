/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.builder;

import com.mycompany.lab2.data.Curse;
import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.data.Outcome;
import com.mycompany.lab2.data.ThreatLevel;
import com.mycompany.lab2.dto.CurseDTO;
import java.util.LinkedHashMap;

/**
 *
 * @author temdo
 */
public class MissionBuilder implements Builder{
    private Mission mission;
    @Override
    public void setMissionId(String missionId) {
        mission.setMissionId(missionId);
    }

    @Override
    public void setDate(String date) {
        mission.setDate(date);
    }

    @Override
    public void setLocaton(String location) {
        mission.setLocation(location);    
    }

    @Override
    public void setOutcome(String outcome) {
        mission.setOutcome(Outcome.valueOf(outcome.toUpperCase()));
    }

    @Override
    public void setCurse(CurseDTO curseDTO) {
        Curse curse = new Curse();
        curse.setName(curseDTO.getName());
        curse.setThreatLevel(ThreatLevel.valueOf(curseDTO.getThreatLevel()));
        mission.setCurse(curse); 
    }

    @Override
    public void setExtras(LinkedHashMap<String, Object> extras) {
        mission.setExtras(extras);    
    }

    @Override
    public void reset() {
        mission = new Mission();
    }
    public Mission getResult(){
        return mission;
    }
    
}
