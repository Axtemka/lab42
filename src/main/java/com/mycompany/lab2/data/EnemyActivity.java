/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.data;

import java.util.List;

/**
 *
 * @author temdo
 */
public class EnemyActivity {
    private String behaviorType;
    private String targetPriority;
    private List<String> attackPatterns;
    private List<String> countermeasuresUsed;
    private Mobility mobility;
    private EscalationRisk escalationRisk;

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

    public List<String> getCountermeasuresUsed() {
        return countermeasuresUsed;
    }

    public void setCountermeasuresUsed(List<String> countermeasuresUsed) {
        this.countermeasuresUsed = countermeasuresUsed;
    }

    public Mobility getMobility() {
        return mobility;
    }

    public void setMobility(Mobility mobility) {
        this.mobility = mobility;
    }

    public EscalationRisk getEscalationRisk() {
        return escalationRisk;
    }

    public void setEscalationRisk(EscalationRisk escalationRisk) {
        this.escalationRisk = escalationRisk;
    }
    
    
}
