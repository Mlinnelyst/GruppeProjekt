package worldofzuul;

import java.util.HashMap;

public class Inventory {

    public HashMap<String, Trash> trash;

    public boolean addTrash(Room room, Trash trash) {
        if (room.trash.containsValue(trash)) {
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
}
