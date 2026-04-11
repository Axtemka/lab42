/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.strategies;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.lab2.builder.Builder;
import com.mycompany.lab2.builder.MissionBuilder;
import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.dto.MissionDTO;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author temdo
 */
public class JsonStrategy implements ParsingStrategy{

    @Override
    public Mission parse(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            MissionDTO missionDTO = mapper.readValue(new File(path), MissionDTO.class);  
            Builder missionBuilder = new MissionBuilder();
            
            missionBuilder.setMissionId(missionDTO.getMissionId());
            missionBuilder.setDate(missionDTO.getDate());
            missionBuilder.setLocaton(missionDTO.getLocation());
            missionBuilder.setOutcome(missionDTO.getOutcome());
            missionBuilder.setCurse(missionDTO.getCurse());
            missionBuilder.setExtras(missionDTO.getExtras());
            
            Mission mission = missionBuilder.getResult();
            return mission;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
