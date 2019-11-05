package worldofzuul;

public class Trash {

    private final String name;
    private final TrashType trashType;

    public Trash(String name, TrashType trashType) {
        this.name = name;
        this.trashType = trashType;
    }

    @Override
    public String toString() {
        return name;
    }

    public TrashType getTrashType() {
        return trashType;
    }
}
