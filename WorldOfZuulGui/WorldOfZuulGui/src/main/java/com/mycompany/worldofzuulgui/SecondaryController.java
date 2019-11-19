package com.mycompany.worldofzuulgui;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.game.play(new Command(CommandWord.GO, "parken", "", ""));
        App.setRoot("primary");
    }
}