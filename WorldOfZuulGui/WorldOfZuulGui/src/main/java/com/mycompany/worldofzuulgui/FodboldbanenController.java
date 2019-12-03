package com.mycompany.worldofzuulgui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.mycompany.worldofzuulgui.WorldOfZuul;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author mads
 */
public class FodboldbanenController {
    @FXML
    private Button goHjem;
    @FXML
    private Pane spawnPane;

    @FXML
    private void goHjemAction() throws IOException {
        App.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }
    
    ArrayList<Trash> trashList = new ArrayList<Trash>();
    
    FodboldbanenController() {
        App.game.inventory.reloadInv(inv1, inv2);
    }
    
    @FXML
    private void trashClicked(MouseEvent event) {
        App.game.inventory.trashClicked(event, trashList, inv1, inv2);
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
}
