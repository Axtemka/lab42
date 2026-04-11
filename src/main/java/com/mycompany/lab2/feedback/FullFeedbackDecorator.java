/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.feedback;

import com.mycompany.lab2.data.Mission;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author temdo
 */
public class FullFeedbackDecorator extends FeedbackDecorator{
    
    public FullFeedbackDecorator(Feedback wrapper, Mission mission) {
        super(wrapper, mission);
    }
    
    @Override
    public String getFeedback(){
        String wrapperFeedback = super.getFeedback();
        Mission currentMission = super.getMission();
        String fb = "\n\n=========Extra information=========\n";
        
        LinkedHashMap<String, Object> extras = currentMission.getExtras();
        
        if (extras == null || extras.isEmpty()) return wrapperFeedback + "\n\n============There is no Extra Information.===========\n";
        for (Map.Entry<String, Object> entry : extras.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value == null) {
                fb += key + ": null\n";
                
            } else if (value instanceof Map) {
                fb += key + ":\n";
                
                for (Map.Entry<String, Object> subEntry : ((Map<String, Object>) value).entrySet()) {
                    fb += "    " + subEntry.getKey() + ": " + subEntry.getValue() + "\n";
                }
            } else if (value instanceof Collection) {
                fb += key + ": " + value.toString() + "\n";
            } else {
                fb += key + ": " + value.toString() + "\n";
            }
        }
        
        return wrapperFeedback + " " + fb;
    }
    
 
}
