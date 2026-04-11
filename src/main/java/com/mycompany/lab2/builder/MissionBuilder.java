/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.builder;

import com.mycompany.lab2.data.CivilianImpact;
import com.mycompany.lab2.data.Curse;
import com.mycompany.lab2.data.EconomicAssessment;
import com.mycompany.lab2.data.EnemyActivity;
import com.mycompany.lab2.data.EnvironmentConditions;
import com.mycompany.lab2.data.EscalationRisk;
import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.data.Mobility;
import com.mycompany.lab2.data.OperationTimeline;
import com.mycompany.lab2.data.Outcome;
import com.mycompany.lab2.data.Rank;
import com.mycompany.lab2.data.Sorcerer;
import com.mycompany.lab2.data.Technique;
import com.mycompany.lab2.data.ThreatLevel;
import com.mycompany.lab2.data.Type;
import com.mycompany.lab2.data.Visibility;
import com.mycompany.lab2.dto.CivilianImpactDTO;
import com.mycompany.lab2.dto.CurseDTO;
import com.mycompany.lab2.dto.EconomicAssessmentDTO;
import com.mycompany.lab2.dto.EnemyActivityDTO;
import com.mycompany.lab2.dto.EnvironmentConditionsDTO;
import com.mycompany.lab2.dto.OperationTimelineDTO;
import com.mycompany.lab2.dto.SorcererDTO;
import com.mycompany.lab2.dto.TechniqueDTO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author temdo
 */
public class MissionBuilder implements Builder{
    private Mission mission = new Mission();
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
    @Override
    public Mission getResult(){
        return mission;
    }

    @Override
    public void setSorcerers(List<SorcererDTO> sorcerersDTO) {
        ArrayList<Sorcerer> sorcerers = new ArrayList();
        if(sorcerersDTO != null){
            if (!sorcerersDTO.isEmpty()){
                for(SorcererDTO sdto: sorcerersDTO){
                    Sorcerer src = new Sorcerer();
                    src.setName(sdto.getName());
                    src.setRank(Rank.valueOf(sdto.getRank()));
                    sorcerers.add(src);
                }
            }    
        }
        mission.setSorcerers(sorcerers);
        
    }

    @Override
    public void setTechniques(List<TechniqueDTO> techniquesDTO) {
        ArrayList<Technique> techniques = new ArrayList();
        if(techniquesDTO != null){
            if (!techniquesDTO.isEmpty()){
                for(TechniqueDTO sdto: techniquesDTO){
                    Technique src = new Technique();
                    src.setName(sdto.getName());
                    src.setOwner(sdto.getOwner());
                    src.setDamage(sdto.getDamage());
                    src.setType(Type.valueOf(sdto.getType()));
                    techniques.add(src);
                }
            }    
        }
        mission.setTechniques(techniques);    
    }

    @Override
    public void setEconomicAssessment(EconomicAssessmentDTO economicAssessmentDTO) {
        EconomicAssessment economicAssessment = new EconomicAssessment();
        if (economicAssessmentDTO != null){
            economicAssessment.setCommercialDamage(economicAssessmentDTO.getCommercialDamage());
            economicAssessment.setInfrastructureDamage(economicAssessmentDTO.getInfrastructureDamage());
            economicAssessment.setInsuranceCovered(economicAssessmentDTO.getInsuranceCovered());
            economicAssessment.setTotalDamageCost(economicAssessmentDTO.getTotalDamageCost());
            economicAssessment.setTransportDamage(economicAssessmentDTO.getTransportDamage());
        }
        mission.setEconomicAssessment(economicAssessment);
    }

    @Override
    public void setCivilianImpact(CivilianImpactDTO civilianImpactDTO) {
        CivilianImpact civilianImpact = new CivilianImpact();
        if (civilianImpactDTO != null){
            civilianImpact.setEvacuated(civilianImpactDTO.getEvacuated());
            civilianImpact.setInjured(civilianImpactDTO.getInjured());
            civilianImpact.setMissing(civilianImpactDTO.getMissing());
            civilianImpact.setPublicExposureRisk(civilianImpactDTO.getPublicExposureRisk());
        }
        mission.setCivilianImpact(civilianImpact);
    }

    @Override
    public void setEnemyActivity(EnemyActivityDTO enemyActivityDTO) {
        EnemyActivity enemyActivity = new EnemyActivity();
        if (enemyActivityDTO != null) {
            enemyActivity.setAttackPatterns(enemyActivityDTO.getAttackPatterns());
            enemyActivity.setBehaviorType(enemyActivityDTO.getBehaviorType());
            enemyActivity.setCountermeasuresUsed(enemyActivityDTO.getCountermeasuresUsed());
            enemyActivity.setTargetPriority(enemyActivityDTO.getTargetPriority());

            String escalationRiskStr = enemyActivityDTO.getEscalationRisk();
            if (escalationRiskStr != null && !escalationRiskStr.trim().isEmpty()) {
                enemyActivity.setEscalationRisk(EscalationRisk.valueOf(escalationRiskStr.trim().toUpperCase()));
            }

            String mobilityStr = enemyActivityDTO.getMobility();
            if (mobilityStr != null && !mobilityStr.trim().isEmpty()) {
                enemyActivity.setMobility(Mobility.valueOf(mobilityStr.trim().toUpperCase()));
            }
        }
        mission.setEnemyActivity(enemyActivity);
    }

    @Override
    public void setEnvironmentConditions(EnvironmentConditionsDTO environmentConditionsDTO) {
        EnvironmentConditions environmentConditions = new EnvironmentConditions();
        if (environmentConditionsDTO != null){
            environmentConditions.setCursedEnergyDensity(environmentConditionsDTO.getCursedEnergyDensity());
            environmentConditions.setTimeOfDay(environmentConditionsDTO.getTimeOfDay());
            environmentConditions.setVisibility(Visibility.valueOf(environmentConditionsDTO.getVisibility()));
            environmentConditions.setWeather(environmentConditionsDTO.getWeather());
        }
        mission.setEnvironmentConditions(environmentConditions);
    }

    @Override
    public void setOperationTimeline(List<OperationTimelineDTO> operationTimelineDTO) {
        ArrayList<OperationTimeline> operationTimelines = new ArrayList();
        if(operationTimelineDTO != null){
            if (!operationTimelineDTO.isEmpty()){
                for(OperationTimelineDTO sdto: operationTimelineDTO){
                    OperationTimeline src = new OperationTimeline();
                    src.setDescription(sdto.getDescription());
                    src.setTimestamp(sdto.getTimestamp());
                    src.setType(sdto.getType());
                    operationTimelines.add(src);
                }
            }    
        }
        mission.setOperationTimeLine(operationTimelines);    
    }
    
}
