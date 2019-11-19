package com.mycompany.worldofzuulgui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.mycompany.worldofzuulgui.WorldOfZuul;

/**
 *
 * @author mads
 */
public class ParkController {
    @FXML
    private Button hjemButton;

    @FXML
    private void gotoHjem() throws IOException {
        App.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }
}
