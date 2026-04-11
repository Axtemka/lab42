/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.data;

/**
 *
 * @author temdo
 */
public class EnvironmentConditions {
    private String weather;
    private String timeOfDay;
    private Visibility visibility;
    private Integer cursedEnergyDensity;

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

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Integer getCursedEnergyDensity() {
        return cursedEnergyDensity;
    }

    public void setCursedEnergyDensity(Integer cursedEnergyDensity) {
        this.cursedEnergyDensity = cursedEnergyDensity;
    }
    
    
}
