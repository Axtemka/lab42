/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.data;

import com.mycompany.lab2.dto.CurseDTO;
import com.mycompany.lab2.feedback.Feedback;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author temdo
 */
public class Mission implements Feedback{
    private String missionId;
    private String date;
    private String location;
    private Outcome outcome;
    private Curse curse;
    private List<Sorcerer> sorcerers;
    private List<Technique> techniques;
    private EconomicAssessment economicAssessment;
    private CivilianImpact civilianImpact;
    private EnemyActivity enemyActivity;
    private EnvironmentConditions environmentConditions;
    private List<OperationTimeline> operationTimeLine;
    
    private LinkedHashMap<String, Object> extras = new LinkedHashMap<String, Object>();

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Curse getCurse() {
        return curse;
    }

    public void setCurse(Curse curse) {
        this.curse = curse;
    }

    public List<Sorcerer> getSorcerers() {
        return sorcerers;
    }

    public void setSorcerers(List<Sorcerer> sorcerers) {
        this.sorcerers = sorcerers;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<Technique> techniques) {
        this.techniques = techniques;
    }

    public EconomicAssessment getEconomicAssessment() {
        return economicAssessment;
    }

    public void setEconomicAssessment(EconomicAssessment economicAssessment) {
        this.economicAssessment = economicAssessment;
    }

    public CivilianImpact getCivilianImpact() {
        return civilianImpact;
    }

    public void setCivilianImpact(CivilianImpact civilianImpact) {
        this.civilianImpact = civilianImpact;
    }

    public EnemyActivity getEnemyActivity() {
        return enemyActivity;
    }

    public void setEnemyActivity(EnemyActivity enemyActivity) {
        this.enemyActivity = enemyActivity;
    }

    public EnvironmentConditions getEnvironmentConditions() {
        return environmentConditions;
    }

    public void setEnvironmentConditions(EnvironmentConditions environmentConditions) {
        this.environmentConditions = environmentConditions;
    }

    public List<OperationTimeline> getOperationTimeLine() {
        return operationTimeLine;
    }

    public void setOperationTimeLine(List<OperationTimeline> operationTimeLineDTO) {
        this.operationTimeLine = operationTimeLineDTO;
    }

    public LinkedHashMap<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(LinkedHashMap<String, Object> extras) {
        this.extras = extras;
    }

    

    @Override
    public String getFeedback() {
        
        String feedback = "";
        return feedback + 
                "\nmissionId: " + missionId + 
                "\ndate: " + date + 
                "\nlocation: " + location + 
                "\noutcome:" + outcome + 
                "\ncurse.name: " + curse.getName() + 
                "\ncurse.threatLevel:" + curse.getThreatLevel();
        
    }
    
}
