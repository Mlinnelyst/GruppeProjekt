package worldofzuul;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Trash> trash;

    public void addTrash(Room room, Trash trash) {
        if (room.trash.containsValue(trash)) {
            this.trash.add(trash);
        }
    }

    public Inventory() {
        trash = new ArrayList<>();
    }

    // Print alle navne på skrald i spillerens inventory
    public void printInventory() {
        System.out.println("-----Inventory-----");

        trash.forEach((trash1) -> {
            System.out.println(trash1.toString());
        });

        System.out.println("-------------------");
    }
}