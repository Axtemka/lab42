/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.dto;

/**
 *
 * @author temdo
 */
public class OperationTimelineDTO {
    private String timestamp;
    private String type;
    private String description;

    public OperationTimelineDTO(String timestamp, String type, String description) {
        this.timestamp = timestamp;
        this.type = type;
        this.description = description;
    }

    public OperationTimelineDTO() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
