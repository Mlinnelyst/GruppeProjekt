package com.mycompany.worldofzuulgui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.mycompany.worldofzuulgui.WorldOfZuul;

/**
 *
 * @author mads
 */
public class HjemController {
    @FXML
   
    private Button goParken;
    @FXML
    private Button goByen;
    @FXML
    private Button goFodboldbanen;

    @FXML
    private void goParkenAction() throws IOException {
        App.game.play(new Command(CommandWord.GO, "parken", "", ""));
        App.setRoot("Parken");
    }
    
    @FXML
    private void goByenAction() throws IOException {
        App.game.play(new Command(CommandWord.GO, "byen", "", ""));
        App.setRoot("Byen");
    }
    
    @FXML
    private void goFodboldbanenAction() throws IOException {
        App.game.play(new Command(CommandWord.GO, "fodboldbanen", "", ""));
        App.setRoot("Fodboldbanen");
    }
}
