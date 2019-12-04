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

    public StrandController() {
        trashList = new ArrayList<>();
        trashList.add(new Trash("bananskrald", TrashType.BANANA));
        trashList.add(new Trash("juice", TrashType.JUICE));
        trashList.add(new Trash("apple", TrashType.APPLE));
        trashList.add(new Trash("avocado", TrashType.AVOCADO));
        trashList.add(new Trash("beerframe", TrashType.BEERFRAME));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File backgroundImage = new File("file:///" + System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\fodbold2.png");
        background.setImage(new Image(backgroundImage.getPath()));

        arrayImage = new ImageView[]{f1, f2, f3};

        WorldOfZuul.game.inventory.reloadInv(inv11, inv22);

        int bX = 795;
        int bY = 597;

        for (int i = 0; i < arrayImage.length; i++) {
            int rnd = new Random().nextInt(trashList.size());

            arrayImage[i].setId(trashList.get(rnd).getTrashType().toString());

            File currentImage = new File("file:///" + System.getProperty("user.dir")
                    + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\" + trashList.get(rnd).getTrashType().toString() + ".png");

            arrayImage[i].setImage(new Image(currentImage.getPath()));

            arrayImage[i].setLayoutX(new Random().nextInt(bX));
            arrayImage[i].setLayoutY(new Random().nextInt(bY));
        }
    }
    
    @FXML
    private void goHjemAction() throws IOException {
        WorldOfZuul.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }

    @FXML
    private void invClicked1(MouseEvent event) {
        WorldOfZuul.game.inventory.btn1Clicked(event);
    }

    @FXML
    private void invClicked2(MouseEvent event) {
        WorldOfZuul.game.inventory.btn2Clicked(event);
    }

    @FXML
    private void trashClicked(MouseEvent event) {
    }

}
