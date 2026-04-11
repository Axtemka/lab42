/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.strategies;

import com.mycompany.lab2.builder.Builder;
import com.mycompany.lab2.builder.MissionBuilder;
import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.dto.CurseDTO;
import com.mycompany.lab2.dto.MissionDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author temdo
 */
public class TextStrategy implements ParsingStrategy{

    @Override
    public Mission parse(String path) {
        Builder missionBuilder = new MissionBuilder();
        Map<String, Integer> sectionCounters = new HashMap<>();
        MissionDTO missionDTO = new MissionDTO();
        String currentSection = null;
        Map<String, String> currentBlock = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.isBlank()) continue;

                if (line.startsWith("[") && line.endsWith("]")) {
                    
                    if (currentSection != null && !currentBlock.isEmpty()){
                        switch (currentSection) {
                        case "MISSION":
                            missionDTO.setMissionId(currentBlock.get("missionId"));
                            if (currentBlock.containsKey("date")) missionDTO.setDate(currentBlock.get("date"));
                            missionDTO.setLocation(currentBlock.get("location"));
                            if (currentBlock.containsKey("outcome")) missionDTO.setOutcome(currentBlock.get("outcome"));
                            if (currentBlock.containsKey("damageCost")) missionDTO.setDamageCost(Integer.valueOf(currentBlock.get("damageCost")));
                            break;

                        case "CURSE":
                            missionDTO.setCurse(new CurseDTO(currentBlock.get("name"), currentBlock.get("threatLevel")));
                            break;
                        default:
                        int counter = sectionCounters.getOrDefault(currentSection, 0);
                        for (Map.Entry<String, String> entry : currentBlock.entrySet()) {
                            String key = currentSection + "." + counter + "." + entry.getKey();
                            missionDTO.getExtras().put(key, entry.getValue());
                        }
                        sectionCounters.put(currentSection, counter + 1);
                        break;
                        }
                    }

                    currentSection = line.substring(1, line.length() - 1).toUpperCase();
                    currentBlock.clear();
                } else if (line.contains("=")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        currentBlock.put(parts[0].trim(), parts[1].trim());
                    }
                }
            }
            if (currentSection != null && !currentBlock.isEmpty()){
                switch (currentSection) {
                    case "MISSION":{
                        
                    
                        missionDTO.setMissionId(currentBlock.get("missionId"));
                        if (currentBlock.containsKey("date")) missionDTO.setDate(currentBlock.get("date"));
                        missionDTO.setLocation(currentBlock.get("location"));
                        if (currentBlock.containsKey("outcome")) missionDTO.setOutcome(currentBlock.get("outcome"));
                        if (currentBlock.containsKey("damageCost")) missionDTO.setDamageCost(Integer.valueOf(currentBlock.get("damageCost")));
                        break;
                    }
                    case "CURSE":{
                        missionDTO.setCurse(new CurseDTO(currentBlock.get("name"), currentBlock.get("threatLevel")));
                        break;
                    }
                    default:
                    int counter = sectionCounters.getOrDefault(currentSection, 0);
                    for (Map.Entry<String, String> entry : currentBlock.entrySet()) {
                        String key = currentSection + "." + counter + "." + entry.getKey();
                        missionDTO.addExtra(key, entry.getValue());
                    }
                    sectionCounters.put(currentSection, counter + 1);
                    break;
                }
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        missionBuilder.setMissionId(missionDTO.getMissionId());
        missionBuilder.setDate(missionDTO.getDate());
        missionBuilder.setLocaton(missionDTO.getLocation());
        missionBuilder.setOutcome(missionDTO.getOutcome());
        missionBuilder.setCurse(missionDTO.getCurse());
        missionBuilder.setExtras(missionDTO.getExtras());

        Mission mission = missionBuilder.getResult();
        return mission;
    }
}
