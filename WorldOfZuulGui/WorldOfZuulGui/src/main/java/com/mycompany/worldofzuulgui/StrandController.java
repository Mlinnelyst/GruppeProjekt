package com.mycompany.worldofzuulgui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.mycompany.worldofzuulgui.WorldOfZuul;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author mads
 */
public class StrandController implements Initializable {

    private ImageView[] arrayImage;
    private ArrayList<Trash> trashList;

    @FXML
    private Button goHjem;
    @FXML
    private Pane spawnPane;
    @FXML
    private Pane inventoryPane;
    @FXML
    private ImageView f1;
    @FXML
    private ImageView f2;
    @FXML
    private ImageView f3;
    @FXML
    private ImageView inv11;
    @FXML
    private ImageView inv22;
    @FXML
    private ImageView background;
    @FXML
    private Text moveTxt;
    @FXML
    private Text scoreTxt;
    @FXML
    private Text sorterTxt;

    public StrandController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File backgroundImage = new File("file:///" + System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\StrandenFinal4.png");
        background.setImage(new Image(backgroundImage.getPath()));

        arrayImage = new ImageView[]{f1, f2, f3};

        WorldOfZuul.game.inventory.reloadInv(inv11, inv22);

        int bX = 912;
        int bY = 228;

        Room currentRoom = WorldOfZuul.game.getCurrentRoom();
        currentRoom.trash.clear();
        currentRoom.spawnTrash(WorldOfZuul.game.inventory);

        Object[] values = currentRoom.trash.values().toArray();
        for (int i = 0; i < currentRoom.trash.size(); i++) {
            Trash currentTrash = (Trash) currentRoom.trash.values().toArray()[i];

            arrayImage[i].setId(currentTrash.getTrashType().toString());

            File currentImage = new File("file:///" + System.getProperty("user.dir")
                    + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\" + currentTrash.toString() + ".png");

            arrayImage[i].setImage(new Image(currentImage.getPath()));

            arrayImage[i].setLayoutX(new Random().nextInt(bX));
            arrayImage[i].setLayoutY(new Random().nextInt(bY));
        }
        
        moveTxt.setText("Besøg: " + WorldOfZuul.game.getMoves());
        scoreTxt.setText("Point: " + WorldOfZuul.game.getScoreCounter().getScore());
        sorterTxt.setText("");
    }

    @FXML
    private void goHjemAction() throws IOException {
        WorldOfZuul.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }

    @FXML
    private void invClicked1(MouseEvent event) {
        WorldOfZuul.game.inventory.slotSelectedHandler(event);
    }

    @FXML
    private void invClicked2(MouseEvent event) {
        WorldOfZuul.game.inventory.slotSelectedHandler(event);
    }

    @FXML
    private void trashClicked(MouseEvent event) {
        Room currentRoom = WorldOfZuul.game.getCurrentRoom();

        ArrayList<Trash> list = new ArrayList<>(currentRoom.trash.values());

        WorldOfZuul.game.inventory.trashClicked(event, list, inv11, inv22);
    }

}
