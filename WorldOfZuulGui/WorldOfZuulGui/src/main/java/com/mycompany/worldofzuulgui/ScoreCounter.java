package com.mycompany.worldofzuulgui;

import DataLayer.ScoreLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ScoreCounter implements ScoreLogger {
    private int score;
    
    public ScoreCounter() {
        this.score = 20;
    }

    public void addScore(int amount) {
        score += amount;
    }

    public void decreaseScore(int amount) {
        score -= amount;
    }

    public void printScore() {
        System.out.println("Score: " + score);
    }

    public int getScore() {
        return score;
    }
    
    public void saveScore(int moves) {
        List<String> data = new ArrayList<>();
       
        data.add("The Recycle Adventurer");
        data.add("-------------------------------");
        
        Date date = new Date();
        data.add(date.toString());
        
        data.add("Besøg: " + moves);
        
        data.add("-------------------------------");
        
        data.add("");
        
        data.addAll(load());
        
        save(data);
    }
    
    public int loadHighestScore() {  
        String tempString;
        ArrayList<Integer> scores = new ArrayList<>();
        
        File dir = new File(System.getProperty("user.dir") + "\\savegame.txt");
        
        try {
            Scanner in = new Scanner(new FileReader(dir));
            
            while (in.hasNextLine()) {
                String line = in.nextLine();
                
                if (line.contains("Besøg")) {
                    Scanner movesInt = new Scanner(line);
                    movesInt.next();
                    scores.add(movesInt.nextInt());
                }
            }            
        } catch (FileNotFoundException ex) {
        }
        
        if (scores.isEmpty()) {
            return 0;
        }
        
        Collections.sort(scores);        
        return scores.get(0);
    }

    @Override
    public void save(List<String> data) {
        File dir = new File(System.getProperty("user.dir") + "\\savegame.txt");
        System.out.println("Dir: " + dir.getPath());
        
        try {
            PrintWriter writer = new PrintWriter(dir);
            
            for (String d : data) {
                writer.println(d);
            }
            
            writer.flush();
            writer.close();            
        } catch (FileNotFoundException ex) {
        }
    }

    @Override
    public List<String> load() {
        List<String> result = new ArrayList<>();
        
        File dir = new File(System.getProperty("user.dir") + "\\savegame.txt");
        
        try {
            Scanner in = new Scanner(new FileReader(dir));
            
            while (in.hasNextLine()) {
                result.add(in.nextLine());
            }            
        } catch (FileNotFoundException ex) {
        }
        
        return result;
    }

}
