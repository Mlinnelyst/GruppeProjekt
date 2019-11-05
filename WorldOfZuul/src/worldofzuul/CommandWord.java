package worldofzuul;

public enum CommandWord {
    GO("besøg"), QUIT("afslut"), HELP("hjælp"), UNKNOWN("?"), THROWOUT("kastud"),
    PICKUP("tag"), INVENTORY("taske"), INVCAN("invcan"), SPAWN("spawn");

    private final String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
