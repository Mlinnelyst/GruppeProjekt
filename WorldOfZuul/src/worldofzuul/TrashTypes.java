package worldofzuul;

public enum TrashTypes {
    PLASTBAG("Plastikpose"), JUICE("Juice karton"),
    BANANA("Bananskrald"), APPLE("Råddent æble"), PIZZA("Rådent pizza skorpe"),
    
    PLAST("Plastikflaske uden pant"), PLASTPANT("Plastikflaske med pant"), PLASTBUCKET("Ødelagt plastik spand"), 
    PLASTSHOVEL("Ødelagt plastik skovl"), CAN("Dåse"), CANPANT("Dåse med pant"), NAILS("Ødelagt søm"),
    
    CARDBOARD("Pap"), BEERFRAME("Ølramme"), 
    PHONE("Ødelagt telefon");
    
    
    private String TrashTypes;

    TrashTypes(String trashTypes) {
        this.TrashTypes = trashTypes;
    }

    @Override
    public String toString() {
        return TrashTypes;
    }
}