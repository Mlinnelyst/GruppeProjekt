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
public class ParkenController implements Initializable {


    @FXML
    private Button goHjem;
    @FXML
    private Pane spawnPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void goHjemAction(ActionEvent event) throws IOException {
        App.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }

}
