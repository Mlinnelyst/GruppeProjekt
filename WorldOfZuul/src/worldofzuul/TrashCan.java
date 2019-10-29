package worldofzuul;
import java.util.ArrayList;

public class TrashCan {
    private String name;
    private ArrayList<Integer> trashType;
    public ArrayList<Trash> trash;
    
    public TrashCan(String name, ArrayList<Integer> trashType){
        trash = new ArrayList<>();
        this.name = name;
        this.trashType = trashType;
        this.trash = new ArrayList<>();
    }
    
    public String toString(){
        return this.name;
    }
    
    public boolean containsTrashType(Integer trashType){
        return this.trashType.contains(trashType);
    }

    // følgende funktion har til opgave at fjerne affald fra players inventory
    // og tilføje affaldet ind til skraldespanden
    public void addTrash(Inventory inv, Trash trash) {
        // først tjekker vi om det objekt overhovedet eksisterer i vores player inventory
        if (inv.trash.contains(trash)) {
            // vi tjekker også om vores skrald har samme skraldetype som vores skraldespand.
            // det vil sige, vi definerer hvilken type skrald vores skraldespand kan acceptere.
            // eksempelvis, kan vi ikke sætte en plastikflaske ind i en mad skraldesprand.
            if (containsTrashType(trash.getTrashType())) {
                // hvis det gør tilføjer vi det til skraldespandens "inventory"
                this.trash.add(trash);

                // vi skal også huske at fjerne objektet fra vores player inventory
                inv.trash.remove(trash);
            }
            else {
                // hvis skraldetypen og skraldespandstypen ikke korrespondere med hinanden
                // udskrives følgende 
                System.out.printf("%s hører ikke til %s skraldespanden!%n", trash.toString(), this.name);
            }
        }    
    }

    // print alle 
    public void printInventory() {
        System.out.printf("----- Inventory of %s trashcan -----%n", this.name);
    
        trash.forEach((trash1) -> {
            System.out.println(trash1.toString());
        });
        
        System.out.println("--------------------------------------");
    }
}