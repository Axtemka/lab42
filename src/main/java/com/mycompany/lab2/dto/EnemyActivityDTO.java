/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.dto;

import java.util.List;

/**
 *
 * @author temdo
 */
public class EnemyActivityDTO {
    private String behaviorType;
    private String targetPriority;
    private List<String> attackPatterns;
    private List<String> countermeasuresUsed;
    private String mobility;
    private String escalationRisk;

    public EnemyActivityDTO(String behaviorType, String targetPriority, List<String> attackPatterns, List<String> countermeasuresUsed, String mobility, String escalationRisk) {
        this.behaviorType = behaviorType;
        this.targetPriority = targetPriority;
        this.attackPatterns = attackPatterns;
        this.countermeasuresUsed = countermeasuresUsed;
        this.mobility = mobility;
        this.escalationRisk = escalationRisk;
    }

    public EnemyActivityDTO() {
    }

    public List<String> getCountermeasuresUsed() {
        return countermeasuresUsed;
    }

    public void setCountermeasuresUsed(List<String> countermeasuresUsed) {
        this.countermeasuresUsed = countermeasuresUsed;
    }

    

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    public String getTargetPriority() {
        return targetPriority;
    }

    public void setTargetPriority(String targetPriority) {
        this.targetPriority = targetPriority;
    }

    public List<String> getAttackPatterns() {
        return attackPatterns;
    }

    public void setAttackPatterns(List<String> attackPatterns) {
        this.attackPatterns = attackPatterns;
    }

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    public String getEscalationRisk() {
        return escalationRisk;
    }

    public void setEscalationRisk(String escalationRisk) {
        this.escalationRisk = escalationRisk;
    }
    
    
}
