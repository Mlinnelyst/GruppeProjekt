package com.mycompany.worldofzuulgui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.mycompany.worldofzuulgui.WorldOfZuul;
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
}
