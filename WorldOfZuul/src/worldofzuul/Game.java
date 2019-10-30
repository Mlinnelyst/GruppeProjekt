package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private int moves;

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room park, hjem, byen, genbrugsplads;
      
        park = new Room("i parken");

        Trash apple = new Trash("Æble", TrashType.FOOD);

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

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Hvad mener du?");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.THROWOUT) {
            throwOut(command);
        } else if (commandWord == CommandWord.PICKUP) {

        }
        
        return wantToQuit;
    }

    private void pickUp(Command command) {
        Inventory playerInventory = new Inventory();
        if(!command.hasSecondWord()) {
            System.out.println("Tag hvad?");
        } else {
            playerInventory
        }
    }

    private void printHelp() 
    {
        System.out.println("Du har kaldt efter hjælp!");
        System.out.println();
        System.out.println("Dine muligheder er:");
        parser.showCommands();
    }

    private void throwOut(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Smid hvad ud?");
            return;
        }
        
        String targetTrash = command.getSecondWord();
        
        System.out.println("I hvilken skraldespand?");
        
        // Print skraldespande
        
    }
    
    private void goRoom(Command command) 
    {

        if(!command.hasSecondWord()) {
            System.out.println("Besoeg hvad?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Du kan ikke gå den vej");
        }
        else {
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

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
