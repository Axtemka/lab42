/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.feedback;

import com.mycompany.lab2.data.Mission;

/**
 *
 * @author temdo
 */
abstract public class FeedbackDecorator implements Feedback{
    private Feedback wrapper;
    private Mission mission;
    
    public FeedbackDecorator(Feedback wrapper, Mission mission){
        this.wrapper = wrapper;
        this.mission = mission;
    }
    
    public Mission getMission(){
        return mission;
    }
   
    @Override
    public String getFeedback(){
        return wrapper.getFeedback();
    }
}
