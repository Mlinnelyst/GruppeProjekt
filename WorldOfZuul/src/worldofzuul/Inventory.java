package worldofzuul;
import java.util.ArrayList;

public class Inventory {
    public ArrayList<Trash> trash;

    // Print alle navne på skrald i spillerens inventory
    public void PrintInventory() {
        System.out.println("-----Inventory-----");
        
        trash.forEach((trash1) -> {
            System.out.println(trash1.toString());
        });
        
        System.out.println("-------------------");
    }
}