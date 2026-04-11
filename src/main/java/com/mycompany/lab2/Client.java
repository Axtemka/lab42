/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycompany.lab2.data.Mission;
import com.mycompany.lab2.feedback.Feedback;
import com.mycompany.lab2.feedback.FullFeedbackDecorator;
import com.mycompany.lab2.strategies.FileStrategy;
import com.mycompany.lab2.strategies.JsonStrategy;
import com.mycompany.lab2.strategies.ParsingContext;
import com.mycompany.lab2.strategies.ParsingStrategy;
import com.mycompany.lab2.strategies.TextStrategy;
import com.mycompany.lab2.strategies.XmlStrategy;
import com.mycompany.lab2.strategies.YamlStrategy;
import java.io.File;
import java.util.Map;
import static java.util.Map.entry;
import java.util.Scanner;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author temdo
 */
public class Client {
    private boolean isRunning;
    
    private Map<String, ParsingStrategy> supportedFileTypes = Map.ofEntries(
            entry("json", new JsonStrategy()),
            entry("xml", new XmlStrategy()),
            entry("txt", new TextStrategy()),
            entry("yaml", new YamlStrategy()),
            entry("", new FileStrategy()));
    
    private Map<String, String> supportedFeedbackOptions = Map.ofEntries(
            entry("1", "fullFeedback")
    );
    
    private Scanner sc = new Scanner(System.in);
    
    public Client() {
        isRunning = true;
        run();
    }
    
    private void run(){
        while(isRunning){
            try{
                System.out.println("Enter filepath. Or stop the programm by entering 'stop'.");
                String input = sc.nextLine();
                if (input.equals("stop")) {
                    stop();
                    break;
                }
                
                String cleanInput = input.replaceAll("\"", ""); 
                String ext = FilenameUtils.getExtension(cleanInput);
                System.out.println(ext);
                
                ParsingContext parsingContext = new ParsingContext();
                
                for (Map.Entry<String, ParsingStrategy> entry : supportedFileTypes.entrySet()) {
                    
                    if (ext.equals(entry.getKey())){
                        parsingContext.setParsingStrategy(entry.getValue());
                        break;
                    }
                }

                Mission mission = parsingContext.useParsingStrategy(cleanInput);
                Feedback missionFeedback = mission;
                String choosedOption = "";
                String optionSequence = "";
                boolean exitFlag = false;
                do{
                    System.out.println("Choose the type of mission feedback.\nYou can choose as many times as you want.");
                    System.out.println("Option sequence: " + optionSequence);
                    System.out.println("exit. Close current file");
                    System.out.println("0. Print report");
                    for (Map.Entry<String, String> entry : supportedFeedbackOptions.entrySet()) {
                        System.out.println(entry.getKey() + ". " + entry.getValue());
                    }
                    choosedOption = sc.nextLine();
                    if (choosedOption.equals("exit")) {
                        exitFlag = true;
                        break;
                    }
                    if (!choosedOption.equals("0")) {
                        missionFeedback = addFeedbackOption(choosedOption, missionFeedback, mission);
                        optionSequence += "[" + choosedOption + "]" + " ";
                    }
                   
                } while(!choosedOption.equals("0"));
                
                if (!exitFlag){
                    System.out.println(missionFeedback.getFeedback());
                    save(mission, ext);
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Something went wrong. Try again");
                
            }
        }
    }
    
    public void stop(){
        isRunning = false;
    }
    public void save(Mission mission, String ext){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(mission.getMissionId() + "__" + ext + "__" + ".json"), mission);
            System.out.println("JSON файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Feedback addFeedbackOption(String choosedOption, Feedback feedback, Mission mission){
        switch(choosedOption){
            case "1": {
                feedback = new FullFeedbackDecorator(feedback, mission);
                break;
            }
        }
        return feedback;
    }
}
