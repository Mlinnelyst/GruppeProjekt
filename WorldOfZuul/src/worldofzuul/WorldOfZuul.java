package worldofzuul;

import java.util.Random;

public class WorldOfZuul {

    public static void main(String[] args) {
        /*Game game = new Game();
        game.play();*/
        
        TrashType item = TrashType.INIT_ITEMS;
        
        Random random = new Random();
        int index = random.nextInt(TrashList.trashList.size());
        
        System.out.println(TrashList.trashList.get(index));
    }
    
}
