package worldofzuul;


public enum TrashType {
    INIT_ITEMS("init"),

    FOOD("Mad"),

    PLASTBAG("Plastikpose"), JUICE("Juice karton"), BANANA("Bananskrald"), APPLE("Råddent æble"), PIZZA("Pizzaskorpe"),

    PLAST("Plastikflaske uden pant"), PLASTPANT("Plastikflaske med pant"), PLASTBUCKET("Ødelagt plastik spand"),
    PLASTSHOVEL("Ødelagt plastik skovl"), CAN("Dåse"), CANPANT("Dåse med pant"), NAILS("Ødelagt søm"),

    CARDBOARD("Pap"), BEERFRAME("Ølramme"), PHONE("Ødelagt telefon");

    private String trashTypes;

    TrashType(String trashTypes) {
        this.trashTypes = trashTypes;

        if (!trashTypes.equals("init")) {
            TrashList.trashList.add(trashTypes);
        }
    }

    @Override
    public String toString() {
        return trashTypes;
    }
}