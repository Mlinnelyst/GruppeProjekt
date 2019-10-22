package worldofzuul;

public class Trash {
    private String name;
    private int trashType;
    
    public Trash(String name, int trashType){
        this.name = name;
        this.trashType = trashType;
    }
    
    public String toString(){
        return name;
    }
    
    public int getTrashType(){
        return trashType;
    }
}
