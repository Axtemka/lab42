/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.builder;

import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.dto.CivilianImpactDTO;
import com.mycompany.lab2.dto.CurseDTO;
import com.mycompany.lab2.dto.EconomicAssessmentDTO;
import com.mycompany.lab2.dto.EnemyActivityDTO;
import com.mycompany.lab2.dto.EnvironmentConditionsDTO;
import com.mycompany.lab2.dto.OperationTimelineDTO;
import com.mycompany.lab2.dto.SorcererDTO;
import com.mycompany.lab2.dto.TechniqueDTO;
import java.util.LinkedHashMap;
import java.util.List;

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
    void setSorcerers(List<SorcererDTO> sorcerersDTO);
    void setTechniques(List<TechniqueDTO> techniquesDTO);
    void setEconomicAssessment(EconomicAssessmentDTO economicAssessment);
    void setCivilianImpact(CivilianImpactDTO civillianImpact);
    void setEnemyActivity(EnemyActivityDTO enemyActivity);
    void setEnvironmentConditions(EnvironmentConditionsDTO environmentConditions);
    void setOperationTimeline(List<OperationTimelineDTO> operationTimeline);
    void setExtras(LinkedHashMap<String, Object> extras);
    Mission getResult();
}
