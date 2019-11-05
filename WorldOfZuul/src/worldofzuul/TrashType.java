package worldofzuul;


public enum TrashType {
    FOOD("mad"), 
    BANANA("bananskrald"), APPLE("råddent_æble"), PIZZA("pizzaskorpe"), AVOCADO("avocado"),
    POTATO("kartoffel"),  
    
    PLASTIC("plastikaffald"), 
    PLAST("plastikflaske_uden_pant"), PLASTBAG("plastikpose"), PLASTBUCKET("ødelagt_plastik_spand"),
    PLASTSHOVEL("ødelagt_plastik_skovl"),
    
    METAL("metalaffald"),
    NAILS("ødelagt_søm"), CAN("dåse"),  
    
    GLAS("glasaffald"),
    GLASSBOTTLE("glasflaske"),
    
    PAPER("papir"), CARDBOARD("pap"),
    JUICE("juice_karton"), BEERFRAME("ølramme"),
    
    PANT("pant"),
    PLASTPANT("plastikflaske_med_pant"), CANPANT("dåse_med_pant"),
    
    GENBRUGS("genbrugsplads"), 
    PHONE("ødelagt_telefon"), LAPTOP("ødelagt_bærbar");

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