/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.strategies;

import com.mycompany.lab2.data.Mission;

/**
 *
 * @author temdo
 */
public class ParsingContext {
    private ParsingStrategy strategy;
    
    public void setParsingStrategy(ParsingStrategy strategy){
        this.strategy = strategy;
    }
    
    public Mission useParsingStrategy(String path){
        return strategy.parse(path);
    }
    
}
