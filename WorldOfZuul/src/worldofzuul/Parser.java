package worldofzuul;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in, "ISO-8859-1");
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;
        String word3 = null;
        String word4 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
                if (tokenizer.hasNext()) {
                    word3 = tokenizer.next();
                    if (tokenizer.hasNext()) {
                        word4 = tokenizer.next();
                    }
                }
            }
        }

        return new Command(commands.getCommandWord(word1), word2, word3, word4);
    }

    public void showCommands() {
        commands.showAll();
    }
}
