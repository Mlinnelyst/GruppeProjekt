package worldofzuul;


public enum TrashType {
    INIT_ITEMS("init"),

    FOOD("mad"),
    PLASTIC("plastikaffald"),
    METAL("metalaffald"),
    GLAS("glasaffald"),
    PAPER("papir"),
    PANT("pant"),
    
    PLASTBAG("plastikpose"), JUICE("juice_karton"), BANANA("bananskrald"), APPLE("råddent_æble"), PIZZA("pizzaskorpe"),

    PLAST("plastikflaske_uden_pant"), PLASTPANT("plastikflaske_med_pant"), PLASTBUCKET("ødelagt_plastik_spand"),
    PLASTSHOVEL("ødelagt_plastik_skovl"), CAN("dåse"), CANPANT("dåse_med_pant"), NAILS("ødelagt_søm"),

    CARDBOARD("pap"), BEERFRAME("ølramme"), PHONE("ødelagt_telefon");

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