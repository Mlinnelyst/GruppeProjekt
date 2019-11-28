/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worldofzuulgui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author XPS
 */
public class ByenController implements Initializable {

    @FXML
    private Button goHjem;
    @FXML
    private Pane spawnPane;
    
    public Button[] arrayButtons;
    
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    
    ArrayList<Trash> trashList = new ArrayList<Trash>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        trashList.add(new Trash("bananskrald", TrashType.BANANA));
        trashList.add(new Trash("juice", TrashType.JUICE));
        trashList.add(new Trash("apple", TrashType.APPLE));
        trashList.add(new Trash("avocado", TrashType.AVOCADO));
        trashList.add(new Trash("beerframe", TrashType.BEERFRAME));
        
        arrayButtons = new Button[] { btn1, btn2, btn3 };
        
        int bX = 795;
        int bY = 597;
        
        for (int i = 0; i < arrayButtons.length; i++){
            int rnd;
            
            rnd = new Random().nextInt(trashList.size());
            
            arrayButtons[i].setText(trashList.get(rnd).toString());
            arrayButtons[i].setId(trashList.get(rnd).getTrashType().toString());

            // Random position
            arrayButtons[i].setLayoutX(new Random().nextInt(bX));
            arrayButtons[i].setLayoutY(new Random().nextInt(bY));
        }
        
        
    }    

    @FXML
    private void goHjemAction(ActionEvent event)throws IOException {
        App.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }

    @FXML
    private void btnClicked(ActionEvent event) {

        
        //File file = new File("file:/home/mads/NetBeansProjects/GruppeProjekt/WorldOfZuulGui/WorldOfZuulGui/target/classes/com/mycompany/worldofzuulgui/billede2.jpeg");
        //Image image = new Image(file.toURI().toString());
        //img1.setImage(image);
        //System.out.println(img1.getImage().getUrl());
        
        Button btn = (Button) event.getSource();
        
        System.out.println(btn.getId());
        
        for (int i = 0; i < trashList.size(); i++) {
            if (trashList.get(i).getTrashType().toString() == btn.getId()) {
                btn.setVisible(!App.game.inventory.addTrash(trashList.get(i)));
            }
        }
        
        App.game.inventory.printInventory();
        reloadInv();
    }
    
    @FXML
    private Button inv1;
    
    @FXML
    private Button inv2;
    
    private void reloadInv() {
        Button invBtns[] = new Button[] { inv1, inv2 };
        
        invBtns[0].setVisible(false);
        invBtns[1].setVisible(false);
        
        int i = 0;
        for (String trash : App.game.inventory.trash.keySet()) {
            invBtns[i].setVisible(true);
            invBtns[i].setText(trash);
            i++;
        }
    }
    
    @FXML
    private void invClicked1(ActionEvent event) {
        System.out.println("1");
    }
    
    @FXML
    private void invClicked2(ActionEvent event) {
        System.out.println("2");
    }
}
