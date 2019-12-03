/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worldofzuulgui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    public Button[] arrayButtons;

    public ImageView[] arrayImage;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;

    ArrayList<Trash> trashList = new ArrayList<Trash>();
    @FXML
    private Pane inventoryPane;
    @FXML
    private ImageView f1;
    @FXML
    private ImageView f2;
    @FXML
    private ImageView f3;
    @FXML
    private ImageView background;
    @FXML
    private ImageView inv11;
    @FXML
    private ImageView inv22;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        File backgroundImage = new File("file:///" + System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\by.png");
        background.setImage(new Image(backgroundImage.getPath()));

        App.game.inventory.reloadInv(inv11, inv22);

        trashList.add(new Trash("bananskrald", TrashType.BANANA));
        trashList.add(new Trash("juice", TrashType.JUICE));
        trashList.add(new Trash("apple", TrashType.APPLE));
        trashList.add(new Trash("avocado", TrashType.AVOCADO));
        trashList.add(new Trash("beerframe", TrashType.BEERFRAME));

        arrayButtons = new Button[]{btn1, btn2, btn3};
        arrayImage = new ImageView[]{f1, f2, f3};

        int bX = 795;
        int bY = 597;

        for (Trash trash : trashList) {
            System.out.println("Trash: " + trash.toString());
        }

        for (int i = 0; i < arrayImage.length; i++) {
            int rnd = new Random().nextInt(trashList.size());

            arrayImage[i].setId(trashList.get(rnd).getTrashType().toString());

            File currentImage = new File("file:///" + System.getProperty("user.dir")
                    + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\" + trashList.get(rnd).getTrashType().toString() + ".png");

            arrayImage[i].setImage(new Image(currentImage.getPath()));

            // Random position
            arrayImage[i].setLayoutX(new Random().nextInt(bX));
            arrayImage[i].setLayoutY(new Random().nextInt(bY));
        }

    }

    @FXML
    private void goHjemAction(ActionEvent event) throws IOException {
        App.game.play(new Command(CommandWord.GO, "hjem", "", ""));
        App.setRoot("Hjem");
    }

    @FXML
    private void invClicked1(MouseEvent event) {
        App.game.inventory.btn1Clicked(event);
    }

    @FXML
    private void invClicked2(MouseEvent event) {
        App.game.inventory.btn2Clicked(event);
    }

    @FXML
    private void trashClicked(MouseEvent event) {
        App.game.inventory.trashClicked(event, trashList, inv11, inv22);
        System.out.println("ada");
    }

}
