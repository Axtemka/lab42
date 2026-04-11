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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author temdo
 */
public class FileStrategy implements ParsingStrategy{
    
    private static final Map<String, List<String>> CANONICAL_FIELDS = Map.of(
        "SORCERER_ASSIGNED", List.of("name", "rank"),
        "TECHNIQUE_USED", List.of("name", "type", "owner", "damage"),
        "TIMELINE_EVENT", List.of("timestamp", "type", "description"),
        "ENEMY_ACTION", List.of("behaviorType", "targetPriority", "mobility", "escalationRisk"),
        "ENVIRONMENT", List.of("weather", "timeOfDay", "visibility", "cursedEnergyDensity"),
        "ECONOMIC_ASSESSMENT", List.of("totalDamageCost", "infrastructureDamage", "commercialDamage", "transportDamage", "recoveryEstimateDays", "insuranceCovered")
    );

    @Override
    public Mission parse(String path) {
        Builder missionBuilder = new MissionBuilder();
        MissionDTO dto = new MissionDTO();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.isBlank()) continue;

                String[] parts = line.split("\\|");
                if (parts.length < 2) continue;

                String command = parts[0].trim();
                processCommand(dto, command, parts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        missionBuilder.setMissionId(dto.getMissionId());
        missionBuilder.setDate(dto.getDate());
        missionBuilder.setLocaton(dto.getLocation());
        missionBuilder.setOutcome(dto.getOutcome());
        missionBuilder.setCurse(dto.getCurse());
        missionBuilder.setSorcerers(dto.getSorcerers());
        missionBuilder.setTechniques(dto.getTechniques());
        missionBuilder.setEconomicAssessment(dto.getEconomicAssessment());
        missionBuilder.setCivilianImpact(dto.getCivilianImpact());
        missionBuilder.setEnemyActivity(dto.getEnemyActivity());
        missionBuilder.setEnvironmentConditions(dto.getEnvironmentConditions());
        missionBuilder.setOperationTimeline(dto.getOperationTimeLineDTO());
        missionBuilder.setExtras(dto.getExtras());

        return missionBuilder.getResult();
    }

    private void processCommand(MissionDTO dto, String command, String[] parts) {
        switch (command) {
            case "MISSION_CREATED":
                if (parts.length >= 4) {
                    dto.setMissionId(parts[1]);
                    dto.setDate(parts[2]);
                    dto.setLocation(parts[3]);
                }
                break;

            case "MISSION_RESULT":
                if (parts.length >= 2) dto.setOutcome(parts[1]);
                if (parts.length >= 3) {
                    Map<String, String> props = parseKeyValuePairs(parts, 2);
                    if (props.containsKey("damageCost")) dto.setDamageCost(Integer.valueOf(props.get("damageCost")));
                }
                break;

            case "CURSE_DETECTED":
                if (parts.length >= 3) {
                    dto.setCurse(new CurseDTO(parts[1], parts[2]));
                }
                break;

            case "SORCERER_ASSIGNED":
                if (parts.length >= 3) {
                    dto.getSorcerers().add(new SorcererDTO(parts[1], parts[2]));
                }
                break;

            case "TECHNIQUE_USED":
                if (parts.length >= 4) {
                    Integer damage = parts.length > 4 ? Integer.valueOf(parts[4]) : null;
                    dto.getTechniques().add(new TechniqueDTO(parts[1], parts[2], parts[3], damage));
                }
                break;

            case "TIMELINE_EVENT":
                if (parts.length >= 4) {
                    dto.getOperationTimeLineDTO().add(new OperationTimelineDTO(parts[1], parts[2], parts[3]));
                }
                break;

            case "CIVILIAN_IMPACT":
                Map<String, String> civProps = parseKeyValuePairs(parts, 1);
                dto.setCivilianImpact(new CivilianImpactDTO(
                    Integer.valueOf(civProps.get("evacuated")),
                    Integer.valueOf(civProps.get("injured")),
                    Integer.valueOf(civProps.get("missing")),
                    civProps.get("publicExposureRisk")
                ));
                break;

            case "ENVIRONMENT":
                Map<String, String> envProps = parseKeyValuePairs(parts, 1);
                dto.setEnvironmentConditions(new EnvironmentConditionsDTO(
                    envProps.get("weather"),
                    envProps.get("timeOfDay"),
                    envProps.get("visibility"),
                    Integer.valueOf(envProps.get("cursedEnergyDensity"))
                ));
                break;

            case "ECONOMIC_ASSESSMENT":
                Map<String, String> ecoProps = parseKeyValuePairs(parts, 1);
                dto.setEconomicAssessment(new EconomicAssessmentDTO(
                    Integer.valueOf(ecoProps.get("totalDamageCost")),
                    Integer.valueOf(ecoProps.get("infrastructureDamage")),
                    Integer.valueOf(ecoProps.get("commercialDamage")),
                    Integer.valueOf(ecoProps.get("transportDamage")),
                    Integer.valueOf(ecoProps.get("recoveryEstimateDays")),
                    Boolean.valueOf(ecoProps.get("insuranceCovered"))
                ));
                break;

            case "ENEMY_ACTION":
                Map<String, String> enemyProps = parseKeyValuePairs(parts, 1);
                if (enemyProps.isEmpty()) {
                    List<String> mapping = CANONICAL_FIELDS.getOrDefault(command, Collections.emptyList());
                    for (int i = 1; i < parts.length; i++) {
                        if (i - 1 < mapping.size()) {
                            enemyProps.put(mapping.get(i - 1), parts[i]);
                        }
                    }
                }
                EnemyActivityDTO enemy = dto.getEnemyActivity() != null ? dto.getEnemyActivity() : new EnemyActivityDTO();
                if (enemyProps.containsKey("behaviorType")) enemy.setBehaviorType(enemyProps.get("behaviorType"));
                if (enemyProps.containsKey("targetPriority")) enemy.setTargetPriority(enemyProps.get("targetPriority"));
                if (enemyProps.containsKey("mobility")) enemy.setMobility(enemyProps.get("mobility"));
                if (enemyProps.containsKey("escalationRisk")) enemy.setEscalationRisk(enemyProps.get("escalationRisk"));
                dto.setEnemyActivity(enemy);
                break;

            default:
                addToExtras(dto, command, parts);
                break;
        }
    }

    private Map<String, String> parseKeyValuePairs(String[] parts, int startIndex) {
        Map<String, String> result = new LinkedHashMap<>();
        for (int i = startIndex; i < parts.length; i++) {
            if (parts[i].contains("=")) {
                String[] kv = parts[i].split("=", 2);
                result.put(kv[0].trim(), kv[1].trim());
            }
        }
        return result;
    }

    private void addToExtras(MissionDTO dto, String command, String[] parts) {
        if (parts.length < 2) return;
        Map<String, String> record = new LinkedHashMap<>();
        List<String> mapping = CANONICAL_FIELDS.getOrDefault(command, Collections.emptyList());

        for (int i = 1; i < parts.length; i++) {
            String raw = parts[i].trim();
            if (raw.isEmpty()) continue;
            if (raw.contains("=")) {
                String[] kv = raw.split("=", 2);
                record.put(kv[0].trim(), kv[1].trim());
            } else {
                String key = (i - 1 < mapping.size()) ? mapping.get(i - 1) : "field_" + i;
                record.put(key, raw);
            }
        }
        if (record.isEmpty()) return;
        List<Map<String, String>> list = (List<Map<String, String>>) dto.getExtras().get(command);
        if (list == null) {
            list = new ArrayList<>();
            dto.getExtras().put(command, list);
        }
        list.add(record);
    }

    
}
