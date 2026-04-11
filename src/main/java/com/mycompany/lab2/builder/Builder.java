/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.builder;

import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.dto.CurseDTO;
import java.util.LinkedHashMap;

/**
 *
 * @author temdo
 */
public interface Builder {
    void reset();
    void setMissionId(String missionId);
    void setDate(String date);
    void setLocaton(String missionId);
    void setOutcome(String outcome);
    void setCurse(CurseDTO curseDTO);
    void setExtras(LinkedHashMap<String, Object> extras);
    Mission getResult();
}
