/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.dto;

/**
 *
 * @author temdo
 */
public class EnvironmentConditionsDTO {
    private String weather;
    private String timeOfDay;
    private String visibility;
    private Integer cursedEnergyDensity;

    public EnvironmentConditionsDTO(String weather, String timeOfDay, String visibility, Integer cursedEnergyDensity) {
        this.weather = weather;
        this.timeOfDay = timeOfDay;
        this.visibility = visibility;
        this.cursedEnergyDensity = cursedEnergyDensity;
    }

    public EnvironmentConditionsDTO() {
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Integer getCursedEnergyDensity() {
        return cursedEnergyDensity;
    }

    public void setCursedEnergyDensity(Integer cursedEnergyDensity) {
        this.cursedEnergyDensity = cursedEnergyDensity;
    }
    
}
