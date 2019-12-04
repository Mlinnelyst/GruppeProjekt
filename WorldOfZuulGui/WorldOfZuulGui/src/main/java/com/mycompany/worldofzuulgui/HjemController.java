package com.mycompany.worldofzuulgui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.mycompany.worldofzuulgui.WorldOfZuul;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author mads
 */
public class HjemController implements Initializable {

    @FXML

    private Button goParken;
    @FXML
    private Button goByen;
    @FXML
    private Button goFodboldbanen;
    @FXML
    private Pane spawnPane;
    @FXML
    private Pane inventoryPane;
    @FXML
    private ImageView inv11;
    @FXML
    private ImageView inv22;
    @FXML
    private Button goStranden;
    @FXML
    private ImageView background;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WorldOfZuul.game.inventory.reloadInv(inv11, inv22);
        
        File backgroundImage = new File("file:///" + System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\hjem2.png");
        background.setImage(new Image(backgroundImage.getPath()));
    }
    
    @FXML
    private void goParkenAction() throws IOException {
        WorldOfZuul.game.play(new Command(CommandWord.GO, "parken", "", ""));
        App.setRoot("Parken");
    }

    @FXML
    private void goByenAction() throws IOException {
        WorldOfZuul.game.play(new Command(CommandWord.GO, "byen", "", ""));
        App.setRoot("Byen");
    }

    @FXML
    private void goFodboldbanenAction() throws IOException {
        WorldOfZuul.game.play(new Command(CommandWord.GO, "fodboldbanen", "", ""));
        App.setRoot("Fodboldbanen");
    }
    
     @FXML
    private void goStrandenAction(ActionEvent event) throws IOException {
        WorldOfZuul.game.play(new Command(CommandWord.GO, "stranden", "", ""));
        App.setRoot("Stranden");
    }

    @FXML
    private void invClicked1(MouseEvent event) {
    }

    @FXML
    private void invClicked2(MouseEvent event) {
    }

}
