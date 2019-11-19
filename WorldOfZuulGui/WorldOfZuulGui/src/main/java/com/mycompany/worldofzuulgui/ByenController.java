/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worldofzuulgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    private Button spawnBanan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Trash banana = new Trash ("Bananskrald", TrashType.BANANA);
        spawnBanan.setText(banana.toString());
        // TODO
    }    

    @FXML
    private void goHjemAction(ActionEvent event)throws IOException {
        App.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }

    @FXML
    private void spawnBananAction(ActionEvent event) {
        spawnBanan.setVisible(false);
        System.out.println("...");
    }
    
}
