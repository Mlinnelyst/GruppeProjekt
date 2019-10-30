package worldofzuul;

public class Trash {
    private String name;
    private TrashType trashType;
    
    public Trash(String name, TrashType trashType){
        this.name = name;
        this.trashType = trashType;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    public TrashType getTrashType(){
        return trashType;
    }
}
