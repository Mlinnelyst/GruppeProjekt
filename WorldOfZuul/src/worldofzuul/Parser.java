package worldofzuul;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            reader = new Scanner(System.in, "ISO-8859-1");
        } else {
            reader = new Scanner(System.in);
        }
    }

    public Command getCommand() {
        String inputLine;
        String[] words = new String[4];
        
        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        
        int i = 0;
        do {
            words[i] = tokenizer.next().toLowerCase();
            i++;
        } while(tokenizer.hasNext());
        
        return new Command(commands.getCommandWord(words[0]), words[1], words[2], words[3]);
    }

    public void showCommands() {
        commands.showAll();
    }
}
