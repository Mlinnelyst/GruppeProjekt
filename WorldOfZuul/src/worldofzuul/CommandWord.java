package worldofzuul;

public enum CommandWord
{
    GO("besoeg"), QUIT("quit"), HELP("help"), UNKNOWN("?"), THROWOUT("kastud"), PICKUP("tag"), INVENTORY("taske");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
