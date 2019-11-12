package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Room {

    // Integer der tæller hvor meget skrald der er spawnet i et rum. 
    static public int spawnCounter;

    // Navnet på rummet som String
    private final String description;
    // Hashmap der beskriver hvilke exits et rum har, altså hvilken vej man kan gå.
    private final HashMap<String, Room> exits;
    // Hashmap der indeholder hvilket skrald der ligger i rummet.
    public HashMap<String, Trash> trash;
    // Hashmap der indeholder hvilke typer skrald der kan spawne i rummet.
    private final HashMap<TrashType, ArrayList<TrashType>> trashSpawn;

    // Room constructor, der tager et String som argument for at angive descriptionen. 
    // Opretter 3 HashMaps.
    public Room(String description) {
        // String argumentet bliver til rummet description. 
        this.description = description;
        // Opretter et HashMap til exits
        exits = new HashMap<>();
        // Opretter et HashMap til trash
        trash = new HashMap<>();
        // Opretter et HashMap til trashSpawn
        trashSpawn = new HashMap<>();
    }

    // Metode der tager en String og et Room som argument.
    // Sætter exit til et bestemt rum og ligger det i exits-HashMappet
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    // Metode der returnerer en kort description.
    public String getShortDescription() {
        return description;
    }

    // Metode der returnerer en lang description.
    public String getLongDescription() {
        // Returnerer description som en String + description + en String med linjeskift (\n) + metoden getExitString
        return "Du befinder dig nu " + description + ".\n" + getExitString();
    }

    //Metoden udskriver en String med noget tekst og alle exits delt op med "|"
    private String getExitString() {
        String returnString = "Du kan tage til: | ";
        // Returnerer en Set-collection af Strings og henter alle keys fra exits
        Set<String> keys = exits.keySet();
        //Tilføjer " | " mellem hver exit
        // Kører set-collectionen keys igennem med et forEach-loop og extender returnStringen med " | " mellem hver exit 
        for (String exit : exits.keySet()) {
            if (!returnString.contains("|")) {
                returnString += " " + exit + " | ";
                continue;
            }

            returnString += exit + " | ";
        }

        // Returnerer returnString
        return returnString;
    }

    // Getter til en exit. 
    public Room getExit(String direction) {
        // Henter en bestemt exit ud fra keyen "description"
        return exits.get(direction);
    }

    // Printer tekst med affald på jorden
    public void printTrash() {
        // Tekst før listen af skrald
        System.out.println("----- Affald på jorden -----");
        // For-Each loop der går alle trash-values
        for (Trash trashPrint : trash.values()) {
            // Kører alle Trash-item 
            System.out.println(trashPrint.toString());
        }
        // Tekst efter listen af skrald
        System.out.println("----------------------------");
    }

    // Metode der tager et Trash objekt som argument. 
    // Tilføjer trash-objektet trash-HashMappet
    public void addTrash(Trash trash) {
        //Sætter med trash-name'et og selve objektet.
        this.trash.put(trash.toString(), trash);
    }

    //Metode der tager et TrashType objekt og et ArrayList et TrashTypes.
    public void addTrashType(TrashType trashType, ArrayList<TrashType> trashTypes) {
        this.trashSpawn.put(trashType, trashTypes);
    }

    // Metode der spawnerTrash i et rum
    public void spawnTrash() {
        //Opretter en et Random objekt
        Random random = new Random();
        // Opretter en int
        int maxTrash = 4;
        
        // Bestemmer antal af skrald der kan spawne i hvert rum. spawner random int mellem 0-3
        int randomInt = (int)(Math.floor(Math.random() * Math.floor(maxTrash)));
        // Ligger 1 til, for at det bliver 1-4, så der uanset hvad spawner noget skrald.
        randomInt++;
        
        
        // For each loop, der kører alle keys i trashSpawn igennem og tæller spawnCounteren op, medmindre 
        for (TrashType spawn : trashSpawn.keySet()) {
            // Hvis mængden af trash er større end 3, springes den trashSpawn over. Der kan altså maks spawnes 4 stykker skrald
            if (trash.size() > 3) {
                continue;
            }

            // Hvis spawnCounter og randomNumber er ens 
            if (spawnCounter % randomInt == 0) {
                int index = random.nextInt(trashSpawn.get(spawn).size());
                ArrayList<TrashType> currentArray = trashSpawn.get(spawn);

                Trash randomTrash = new Trash(currentArray.get(index).toString(), spawn);
                trash.put(randomTrash.toString(), randomTrash);
            }
            spawnCounter++;
        }
    }
}
