package worldofzuul;


public enum TrashType {
    INIT_ITEMS("init"),

    FOOD("mad"),

    PLASTBAG("plastikpose"), JUICE("juice karton"), BANANA("bananskrald"), APPLE("råddent æble"), PIZZA("pizzaskorpe"),

    PLAST("plastikflaske uden pant"), PLASTPANT("plastikflaske med pant"), PLASTBUCKET("ødelagt plastik spand"),
    PLASTSHOVEL("ødelagt plastik skovl"), CAN("dåse"), CANPANT("dåse med pant"), NAILS("ødelagt søm"),

    CARDBOARD("pap"), BEERFRAME("ølramme"), PHONE("ødelagt telefon");

    private final String trashTypes;

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