package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Trash> trash;
    private ArrayList<TrashType> trashTypes;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        trash = new ArrayList<>();
        trashTypes = new ArrayList<>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    public void setTrash(String room, ArrayList<Trash> trashTypes) {
        
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "Du befinder dig nu " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Du kan tage til";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " | " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
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
    
    public void addTrashType(TrashType trashType) {
        this.trashTypes.add(trashType);
    }
    
    public void spawnTrash () {
        Random random = new Random();
        Random random2 = new Random();
        int index = random.nextInt(trashTypes.size());
        
        Boolean spawned = false;
        while (!spawned) {
            int index2 = random.nextInt(TrashList.trashList.size());
            if (trashTypes.get(index).toString().contentEquals(TrashList.trashList.get(index2))) {
                spawned = true;
                trash.add(new Trash(trashTypes.get(index).toString(), trashTypes.get(index)));
            }
        }
        
    }
}

