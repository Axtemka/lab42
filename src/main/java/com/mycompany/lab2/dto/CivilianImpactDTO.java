/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.dto;

/**
 *
 * @author temdo
 */
public class CivilianImpactDTO {
    private Integer evacuated;
    private Integer injured;
    private Integer missing;
    private String publicExposureRisk;

    public CivilianImpactDTO() {
    }

    public CivilianImpactDTO(Integer evacuated, Integer injured, Integer missing, String publicExposureRisk) {
        this.evacuated = evacuated;
        this.injured = injured;
        this.missing = missing;
        this.publicExposureRisk = publicExposureRisk;
    }

    public Integer getEvacuated() {
        return evacuated;
    }

    public void setEvacuated(Integer evacuated) {
        this.evacuated = evacuated;
    }

    public Integer getInjured() {
        return injured;
    }

    public void setInjured(Integer injured) {
        this.injured = injured;
    }

    public Integer getMissing() {
        return missing;
    }

    public void setMissing(Integer missing) {
        this.missing = missing;
    }

    public String getPublicExposureRisk() {
        return publicExposureRisk;
    }

    public void setPublicExposureRisk(String publicExposureRisk) {
        this.publicExposureRisk = publicExposureRisk;
    }
    
    
    
}
