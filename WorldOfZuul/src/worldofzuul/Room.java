package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Room {
    private String description;
    private HashMap<String, Room> exits;
    public ArrayList<Trash> trash;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        trash = new ArrayList<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "Du befinder dig nu " + description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Du kan tage til";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " | " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void printTrash() {
        System.out.println("----- Affald på jorden -----");

        trash.forEach((trash1) -> {
            System.out.println(trash1.toString());
        });

        System.out.println("----------------------------");
    }

    public void addTrash(Trash trash) {
        this.trash.add(trash);
    }
}
