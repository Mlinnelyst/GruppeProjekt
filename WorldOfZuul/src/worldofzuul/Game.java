package worldofzuul;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private Parser parser;

    private Room currentRoom;
    private HashMap<String, Room> rooms;

    private int moves;
    private Inventory inventory;
    private ScoreCounter score;

    private HashMap<String, TrashCan> trashCans;

    public Game() {
        createRooms();
        parser = new Parser();
        inventory = new Inventory();
        score = new ScoreCounter();
        trashCans = new HashMap<>();

        ArrayList<TrashType> foodTrashType = new ArrayList<>();
        foodTrashType.add(TrashType.FOOD);

        TrashCan food = new TrashCan("madaffald", foodTrashType, score);

        ArrayList<TrashType> metalTrashType = new ArrayList<>();
        metalTrashType.add(TrashType.PLAST);
        metalTrashType.add(TrashType.METAL);
        metalTrashType.add(TrashType.GLAS);

        TrashCan metalplastCan = new TrashCan("metal_glas_plast", metalTrashType, score);

        ArrayList<TrashType> papirPapTrashType = new ArrayList<>();
        papirPapTrashType.add(TrashType.PAPER);
        papirPapTrashType.add(TrashType.CARDBOARD);

        TrashCan papirPapCan = new TrashCan("papir_pap", papirPapTrashType, score);

        ArrayList<TrashType> pantTrashType = new ArrayList<>();
        pantTrashType.add(TrashType.PANT);

        TrashCan pantCan = new TrashCan("pant", pantTrashType, score);

        trashCans.put(food.toString(), food);
        trashCans.put(metalplastCan.toString(), metalplastCan);
        trashCans.put(papirPapCan.toString(), papirPapCan);
        trashCans.put(pantCan.toString(), pantCan);
    }

    private void createRooms() {
        Room park, hjem, byen, genbrugsplads;

        rooms = new HashMap<>();

        park = new Room("i parken");
        ArrayList<TrashType> foodTypes = new ArrayList<>();
        foodTypes.add(TrashType.BANANA);
        foodTypes.add(TrashType.APPLE);
        foodTypes.add(TrashType.PIZZA);
        foodTypes.add(TrashType.AVOCADO);
        foodTypes.add(TrashType.POTATO);

        ArrayList<TrashType> plasticTypes = new ArrayList<>();
        plasticTypes.add(TrashType.PLAST);
        plasticTypes.add(TrashType.PLASTBAG);
        plasticTypes.add(TrashType.PLASTBUCKET);
        plasticTypes.add(TrashType.PLASTSHOVEL);

        ArrayList<TrashType> metalTypes = new ArrayList<>();
        metalTypes.add(TrashType.NAILS);
        metalTypes.add(TrashType.CAN);

        ArrayList<TrashType> glassTypes = new ArrayList<>();
        glassTypes.add(TrashType.GLASSBOTTLE);

        ArrayList<TrashType> paperCardboard = new ArrayList<>();
        paperCardboard.add(TrashType.JUICE);
        paperCardboard.add(TrashType.BEERFRAME);

        ArrayList<TrashType> pantTypes = new ArrayList<>();
        pantTypes.add(TrashType.PLASTPANT);
        pantTypes.add(TrashType.CANPANT);

        park.addTrashType(TrashType.FOOD, foodTypes);
        park.addTrashType(TrashType.PLASTIC, plasticTypes);
        park.addTrashType(TrashType.METAL, metalTypes);
        park.addTrashType(TrashType.GLAS, glassTypes);
        park.addTrashType(TrashType.PAPER, paperCardboard);
        park.addTrashType(TrashType.CARDBOARD, paperCardboard);
        park.addTrashType(TrashType.PANT, pantTypes);

        hjem = new Room("derhjemme");

        hjem.addTrashType(TrashType.FOOD, foodTypes);
        hjem.addTrashType(TrashType.PLASTIC, plasticTypes);
        hjem.addTrashType(TrashType.PANT, pantTypes);

        byen = new Room("i byen");

        byen.addTrashType(TrashType.FOOD, foodTypes);
        byen.addTrashType(TrashType.PLASTIC, plasticTypes);
        byen.addTrashType(TrashType.METAL, metalTypes);
        byen.addTrashType(TrashType.GLAS, glassTypes);
        byen.addTrashType(TrashType.PAPER, paperCardboard);
        byen.addTrashType(TrashType.CARDBOARD, paperCardboard);
        byen.addTrashType(TrashType.PANT, pantTypes);

        genbrugsplads = new Room("på genbrugspladsen");

        hjem.setExit("parken", park);
        hjem.setExit("byen", byen);
        hjem.setExit("genbrugspladsen", genbrugsplads);

        byen.setExit("hjem", hjem);

        park.setExit("hjem", hjem);

        genbrugsplads.setExit("hjem", hjem);

        currentRoom = hjem;

        park.spawnTrash();
        byen.spawnTrash();
        genbrugsplads.spawnTrash();

        rooms.put("hjem", hjem);
        rooms.put("parken", park);
        rooms.put("byen", byen);
        rooms.put("genbrugspladsen", genbrugsplads);
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Hello Gamer, Welcome to the Big dick club");
        System.out.println("This game is all about big dick energy.");
        System.out.println("Skriv '" + CommandWord.HELP + "' hvis du ikke forstår noget.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case THROWOUT:
                throwOut(command);
                break;
            case PICKUP:
                pickUp(command);
                break;
            case INVENTORY:
                inventory.printInventory();
                break;
            case INVCAN:
                for (String trashCan : trashCans.keySet()) {
                    System.out.printf("----- %s affald -----%n", trashCan);

                    for (Trash trash : trashCans.get(trashCan).trash) {
                        System.out.println(trash.toString());
                    }

                    System.out.println("----------------------");
                }
                break;
            default:
                System.out.println("Hvad mener du?");
                break;
        }

        return wantToQuit;
    }

    private void pickUp(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Tag hvad?");
        } else {
            String targetTrash = command.getSecondWord();
            if (command.hasThirdWord()) {
                targetTrash += " " + command.getThirdWord();

                if (command.hasFourthWord()) {
                    targetTrash += " " + command.getFourthWord();
                }
            }

            if (!currentRoom.trash.containsKey(targetTrash)) {
                System.out.printf("%s eksisterer ikke i rummet!%n", targetTrash);
                return;
            }

            if (inventory.addTrash(currentRoom, currentRoom.trash.get(targetTrash))) {
                currentRoom.trash.remove(targetTrash);
                System.out.printf("Tilføjet %s til din taske!%n", targetTrash.toLowerCase());
            }
        }
    }

    private void printHelp() {
        System.out.println("Du har kaldt efter hjælp!\n"); // \n = new line
        System.out.println("Dine muligheder er:");
        parser.showCommands();
    }

    private void throwOut(Command command) {
        if (!currentRoom.getShortDescription().contains("derhjemme")) {
            System.out.println("Du skal være hjemme for at kunne sortere dit affald!");
            return;
        }

        if (!command.hasSecondWord()) {
            System.out.println("Smid hvad ud?");
            return;
        }

        String targetTrashCan = command.getSecondWord();

        String targetTrash = command.getThirdWord();
        Trash currentTrash = inventory.trash.get(targetTrash);

        TrashCan currentTrashCan = trashCans.get(targetTrashCan);

        if (currentTrashCan.addTrash(inventory, currentTrash)) {
            System.out.printf("%nTilføjet %s til %s skraldespand.%n", currentTrash.toString().toLowerCase(), currentTrashCan.toString());
        }
    }

    private void goRoom(Command command) {

        if (!command.hasSecondWord()) {
            System.out.println("Besøg hvad?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Du kan ikke gå den vej");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());

            if (currentRoom.getShortDescription().contains("derhjemme")) {
                System.out.println("\n----- Skraldespande -----");
                for (String can : trashCans.keySet()) {
                    System.out.println(can);
                }
                System.out.println("-------------------------");
            }

            if (!currentRoom.trash.isEmpty()) {
                currentRoom.printTrash();
            }

            if (moves % 3 == 0) {
                for (String room : rooms.keySet()) {
                    rooms.get(room).spawnTrash();
                }
            }

            moves++;
            score.printScore();
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
