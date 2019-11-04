package worldofzuul;

import java.util.HashMap;

public class Inventory {
    public HashMap<String, Trash> trash;

    public void addTrash(Room room, Trash trash) {        
        if (room.trash.containsValue(trash)) {
            this.trash.put(trash.toString(), trash);
        }
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