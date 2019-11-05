package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Room {

    static public int spawnCounter;

    private String description;
    private HashMap<String, Room> exits;
    public HashMap<String, Trash> trash;
    private HashMap<String, ArrayList<TrashType>> trashSpawn;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        trash = new HashMap<>();
        trashSpawn = new HashMap<>();
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

        for (Trash trash : trash.values()) {
            System.out.println(trash.toString());
        }

        System.out.println("----------------------------");
    }

    public void addTrash(Trash trash) {
        this.trash.put(trash.toString(), trash);
    }

    public void addTrashType(TrashType trashType, ArrayList<TrashType> trashTypes) {
        this.trashSpawn.put(trashType.toString(), trashTypes);
    }

    public void spawnTrash() {
        Random random = new Random();
        int randomNumber = (int)(Math.floor((Math.random() * 4) + 1));
        
        if (randomNumber == 0) {
            randomNumber++;
        }
        
        for (String spawn : trashSpawn.keySet()) {     
            if (trash.size() > 3) {
                continue;
            } 
            
            if (spawnCounter % randomNumber == 0) {
                int index = random.nextInt(trashSpawn.get(spawn).size());
                ArrayList<TrashType> currentArray = trashSpawn.get(spawn);

                Trash randomTrash = new Trash(currentArray.get(index).toString(), currentArray.get(index));
                trash.put(randomTrash.toString(), randomTrash);
            }
            spawnCounter++;
        }
    }
}
