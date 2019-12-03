package com.mycompany.worldofzuulgui;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Inventory {

    // Hashmap til opbevaring af skraldeobjekter i spillerens inventar
    public HashMap<String, Trash> trash;

    // Tilføj skrald fra rummet til spillerens inventar
    public boolean addTrash(Room room, Trash trash) {
        // Check om rummet indeholder skraldet
        if (room.trash.containsValue(trash)) {
            // Check om spilleren har plads
            if (this.trash.size() < 2) {
                this.trash.put(trash.toString(), trash);
                return true;
            } else {
                System.out.println("Du har ikke mere plads i hænderne!");
                return false;
            }
        }
        return false;
    }

    public boolean addTrash(Trash trash) {
        if (this.trash.containsKey(trash.toString())) {
            System.out.println("Din inventory indeholder allerede denne skraldtype.");
            return false;
        }

        if (this.trash.size() < 2) {
            this.trash.put(trash.toString(), trash);
            return true;
        } else {
            System.out.println("Du har ikke mere plads i hænderne!");
            return false;
        }
    }

    // Opret trash-hashmappet i constructeren
    public Inventory() {
        trash = new HashMap<>();
    }

    // Print alle navne på skrald i spillerens inventory
    public void printInventory() {
        System.out.println("-----Inventory-----");

        for (String trash : trash.keySet()) {
            System.out.println(trash);
        }

        System.out.println("-------------------");
    }

    // Trash clicked from fxml
    public void trashClicked(MouseEvent event, ArrayList<Trash> trashList, ImageView inv1, ImageView inv2) {
        ImageView image = (ImageView) event.getSource();
        // Button btn = (Button) event.getSource();

        System.out.println(image.getId());

        for (int i = 0; i < trashList.size(); i++) {
            if (trashList.get(i).getTrashType().toString() == image.getId()) {
                image.setVisible(!App.game.inventory.addTrash(trashList.get(i)));
            }
        }

        App.game.inventory.printInventory();
        App.game.inventory.reloadInv(inv1, inv2);
    }

    // Reload gui
    public void reloadInv(ImageView btn1, ImageView btn2) {
        ImageView invBtns[] = new ImageView[]{btn1, btn2};

        invBtns[0].setVisible(false);
        invBtns[1].setVisible(false);

        int i = 0;
        for (String lol : trash.keySet()) {
            invBtns[i].setVisible(true);

            File currentImage = new File("file:///" + System.getProperty("user.dir")
                    + "\\src\\main\\java\\com\\mycompany\\JavaBilleder1\\" + trash.get(lol).getTrashType().toString() + ".png");
            invBtns[i].setImage(new Image(currentImage.getPath()));

            i++;
        }
    }

    public void btn1Clicked(MouseEvent event) {
        System.out.println("1");
    }

    public void btn2Clicked(MouseEvent event) {
        System.out.println("2");
    }

}
