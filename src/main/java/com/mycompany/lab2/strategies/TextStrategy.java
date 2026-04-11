/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.strategies;

import com.mycompany.lab2.builder.Builder;
import com.mycompany.lab2.builder.MissionBuilder;
import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.dto.CivilianImpactDTO;
import com.mycompany.lab2.dto.CurseDTO;
import com.mycompany.lab2.dto.EconomicAssessmentDTO;
import com.mycompany.lab2.dto.EnemyActivityDTO;
import com.mycompany.lab2.dto.EnvironmentConditionsDTO;
import com.mycompany.lab2.dto.MissionDTO;
import com.mycompany.lab2.dto.OperationTimelineDTO;
import com.mycompany.lab2.dto.SorcererDTO;
import com.mycompany.lab2.dto.TechniqueDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author temdo
 */
public class TextStrategy implements ParsingStrategy{

    @Override
    public Mission parse(String path) {
        MissionDTO missionDTO = new MissionDTO();
        String currentSection = null;
        Builder missionBuilder = new MissionBuilder();
        Map<String, String> currentBlock = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.isBlank()) continue;

                if (line.startsWith("[") && line.endsWith("]")) {

                    processBlock(missionDTO, currentSection, currentBlock);
                    currentSection = line.substring(1, line.length() - 1).toUpperCase();
                    currentBlock.clear();
                } else if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        currentBlock.put(parts[0].trim(), parts[1].trim());
                    }
                }
            }
            processBlock(missionDTO, currentSection, currentBlock);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        missionBuilder.setMissionId(missionDTO.getMissionId());
        missionBuilder.setDate(missionDTO.getDate());
        missionBuilder.setLocaton(missionDTO.getLocation());
        missionBuilder.setOutcome(missionDTO.getOutcome());
        missionBuilder.setCurse(missionDTO.getCurse());
        missionBuilder.setSorcerers(missionDTO.getSorcerers());
        missionBuilder.setTechniques(missionDTO.getTechniques());
        missionBuilder.setEconomicAssessment(missionDTO.getEconomicAssessment());
        missionBuilder.setCivilianImpact(missionDTO.getCivilianImpact());
        missionBuilder.setEnemyActivity(missionDTO.getEnemyActivity());
        missionBuilder.setEnvironmentConditions(missionDTO.getEnvironmentConditions());
        missionBuilder.setOperationTimeline(missionDTO.getOperationTimeLineDTO());
        missionBuilder.setExtras(missionDTO.getExtras());

        Mission mission = missionBuilder.getResult();
        return mission;
    }

    private void processBlock(MissionDTO dto, String section, Map<String, String> props) {
        if (section == null || props.isEmpty()) return;

        switch (section) {
            case "MISSION":
                dto.setMissionId(props.get("missionId"));
                dto.setDate(props.get("date"));
                dto.setLocation(props.get("location"));
                dto.setOutcome(props.get("outcome"));
                dto.setDamageCost(Integer.valueOf(props.get("damageCost")));
                break;

            case "CURSE":
                dto.setCurse(new CurseDTO(props.get("name"), props.get("threatLevel")));
                break;

            case "SORCERER":
                // Повторяющаяся секция → добавляем в список
                dto.getSorcerers().add(new SorcererDTO(props.get("name"), props.get("rank")));
                break;

            case "TECHNIQUE":
                // Повторяющаяся секция → добавляем в список
                dto.getTechniques().add(new TechniqueDTO(
                    props.get("name"),
                    props.get("type"),
                    props.get("owner"),
                    Integer.valueOf(props.get("damage"))
                ));
                break;

            case "ECONOMIC":
                dto.setEconomicAssessment(new EconomicAssessmentDTO(
                    Integer.valueOf(props.get("totalDamageCost")),
                    Integer.valueOf(props.get("infrastructureDamage")),
                    Integer.valueOf(props.get("commercialDamage")),
                    Integer.valueOf(props.get("transportDamage")),
                    Integer.valueOf(props.get("recoveryEstimateDays")),
                    Boolean.valueOf(props.get("insuranceCovered"))
                ));
                break;

            case "CIVILIAN":
                dto.setCivilianImpact(new CivilianImpactDTO(
                    Integer.valueOf(props.get("evacuated")),
                    Integer.valueOf(props.get("injured")),
                    Integer.valueOf(props.get("missing")),
                    props.get("publicExposureRisk")
                ));
                break;

            case "ENEMY":
                dto.setEnemyActivity(new EnemyActivityDTO(
                    props.get("behaviorType"),
                    props.get("targetPriority"),
                    parseList(props.get("attackPatterns")),
                    parseList(props.get("countermeasuresUsed")),
                    props.get("mobility"),
                    props.get("escalationRisk")
                ));
                break;

            case "ENVIRONMENT":
                dto.setEnvironmentConditions(new EnvironmentConditionsDTO(
                    props.get("weather"),
                    props.get("timeOfDay"),
                    props.get("visibility"),
                    Integer.valueOf(props.get("cursedEnergyDensity"))
                ));
                break;

            case "TIMELINE":
                // Повторяющаяся секция → добавляем в список
                dto.getOperationTimeLineDTO().add(new OperationTimelineDTO(
                    props.get("timestamp"),
                    props.get("type"),
                    props.get("description")
                ));
                break;

            default:
                
                break;
        }
    }
    
    private List<String> parseList(String val) {
        if (val == null || val.trim().isEmpty()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(val.split(",")));
    }

}
