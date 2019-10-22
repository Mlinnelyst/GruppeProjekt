package worldofzuul;
import java.util.ArrayList;

public class TrashCan {
    private String name;
    private ArrayList<Integer> trashType;
    public ArrayList<Trash> trash;
    
    public TrashCan(String name, ArrayList<Integer> trashType){
        this.name = name;
        this.trashType = trashType;
    }
    
    public String toString(){
        return this.name;
    }
    
    public boolean containsTrashType(Integer trashType){
        return this.trashType.contains(trashType);
    }
}
