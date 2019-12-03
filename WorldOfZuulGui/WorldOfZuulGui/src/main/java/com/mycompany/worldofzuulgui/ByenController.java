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
import javafx.scene.input.MouseEvent;
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
    
    public ImageView[] arrayImage;
    
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    
    ArrayList<Trash> trashList = new ArrayList<Trash>();
    @FXML
    private Pane inventoryPane;
    @FXML
    private ImageView f1;
    @FXML
    private ImageView f2;
    @FXML
    private ImageView f3;
    @FXML
    private ImageView background;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        App.game.inventory.reloadInv(inv1, inv2);
        
        trashList.add(new Trash("bananskrald", TrashType.BANANA));
        trashList.add(new Trash("juice", TrashType.JUICE));
        trashList.add(new Trash("apple", TrashType.APPLE));
        trashList.add(new Trash("avocado", TrashType.AVOCADO));
        trashList.add(new Trash("beerframe", TrashType.BEERFRAME));
        
        arrayButtons = new Button[] { btn1, btn2, btn3 };
        arrayImage = new ImageView[] {f1,f2,f3};
        
        
        int bX = 795;
        int bY = 597;
        
        for (int i = 0; i < arrayImage.length; i++){
            int rnd = new Random().nextInt(trashList.size());
            
            arrayImage[i].setId(trashList.get(rnd).getTrashType().toString());
            arrayImage[i].se

            // Random position
            arrayImage[i].setLayoutX(new Random().nextInt(bX));
            arrayImage[i].setLayoutY(new Random().nextInt(bY));
        }
        
        
    }    

    @FXML
    private void goHjemAction(ActionEvent event)throws IOException {
        App.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }

    @FXML
    private void trashClicked(ActionEvent event) {
        
    }
    
    @FXML
    private Button inv1;
    
    @FXML
    private Button inv2;
    
    @FXML
    private void invClicked1(ActionEvent event) {
        App.game.inventory.btn1Clicked(event);
    }
    
    @FXML
    private void invClicked2(ActionEvent event) {
        App.game.inventory.btn2Clicked(event);
    }

    @FXML
    private void trashClicked(MouseEvent event) {
       App.game.inventory.trashClicked(event, trashList, inv1, inv2);
        System.out.println("ada");
    }
    
}
