package worldofzuul;

public class Trash {
    private final String name;
    private final TrashType trashType;
    
    public Trash(TrashType name, TrashType trashType){
        this.name = name.toString();
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
