package worldofzuul;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private int moves;
    private Inventory inventory;

    public Game() {
        createRooms();
        parser = new Parser();
        inventory = new Inventory();
    }

    private void createRooms() {
        Room park, hjem, byen, genbrugsplads;

        park = new Room("i parken");

        Trash apple = new Trash("Apple", TrashType.FOOD);

        park.addTrash(apple);

        hjem = new Room("derhjemme");
        byen = new Room("i byen");
        genbrugsplads = new Room("på genbrugspladsen");

        hjem.setExit("parken", park);
        hjem.setExit("byen", byen);
        hjem.setExit("genbrugspladsen", genbrugsplads);

        byen.setExit("hjem", hjem);
        park.setExit("hjem", hjem);
        genbrugsplads.setExit("hjem", hjem);

        currentRoom = hjem;
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
        System.out.println("Skriv '" + CommandWord.HELP + "' hvis du ikke fatter noget.");
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

            if (!currentRoom.trash.containsKey(targetTrash)) {
                System.out.printf("%s eksisterer ikke i rummet!%n", targetTrash);
                return;
            }

            inventory.addTrash(currentRoom, currentRoom.trash.get(targetTrash));
            currentRoom.trash.remove(targetTrash);

            System.out.printf("Tilføjet %s til din taske!%n", targetTrash);
        }
    }

    private void printHelp() {
        System.out.println("Du har kaldt efter hjælp!");
        System.out.println();
        System.out.println("Dine muligheder er:");
        parser.showCommands();
    }

    private void throwOut(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Smid hvad ud?");
            return;
        }

        String targetTrash = command.getSecondWord();

        System.out.println("I hvilken skraldespand?");

        // Print skraldespande
    }

    private void goRoom(Command command) {

        if (!command.hasSecondWord()) {
            System.out.println("Besoeg hvad?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Du kan ikke gå den vej");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());

            moves++;
            if (moves % 2 == 0) {
                System.out.println("Add Trash");
            } else {
                System.out.println("You moved");
            }
            currentRoom.printTrash();
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
