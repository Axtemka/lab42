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
import com.mycompany.lab2.dto.SorcererDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author temdo
 */
public class FileStrategy implements ParsingStrategy{

    @Override
    public Mission parse(String path) {
        MissionDTO missionDTO = new MissionDTO();
        Builder missionBuilder = new MissionBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split("\\|", -1); // -1 сохраняет пустые токены
                if (parts.length < 2) continue;

                String command = parts[0].trim();
                
                processCommand(missionDTO, command, parts);
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

    private void processCommand(MissionDTO dto, String command, String[] parts) {
        switch (command) {
            case "MISSION_CREATED":{
                if (parts.length >= 4) {
                    dto.setMissionId(parts[1]);
                    dto.setDate(parts[2]);
                    dto.setLocation(parts[3]);
                }
                break;
            }
            
            case "MISSION_RESULT":
                if (parts.length >= 2) {
                    dto.setOutcome(parts[1]);
                }
                if (parts.length >= 3) {
                    Map<String, String> resultProps = parseKeyValuePairs(parts, 2);
                    if (resultProps.containsKey("damageCost")) {
                        dto.setDamageCost(Integer.valueOf(resultProps.get("damageCost")));
                    }
                }
                break;

            
            case "CURSE_DETECTED":{
                if (parts.length >= 3) {
                    dto.setCurse(new CurseDTO(parts[1], parts[2]));
                }
                break;
            }
            default:{
                if (parts.length < 2) return;
                // 1. Собираем параметры ТЕКУЩЕЙ строки в отдельный список
                List<String> currentRecord = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    String param = parts[i].trim();
                    if (!param.isEmpty()) {
                        currentRecord.add(param);
                    }
                }
                if (currentRecord.isEmpty()) return;

                // 2. Получаем или создаем общий контейнер для этой команды
                @SuppressWarnings("unchecked")
                List<List<String>> allRecords = (List<List<String>>) dto.getExtras().get(command);
                if (allRecords == null) {
                    allRecords = new ArrayList<>();
                    dto.getExtras().put(command, allRecords);
                }

                // 3. Добавляем запись как отдельный элемент
                allRecords.add(currentRecord);
            }
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
}
