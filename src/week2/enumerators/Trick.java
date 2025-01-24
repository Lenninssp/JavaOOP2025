package week2.enumerators;

public enum Trick {
    JUMP("Jump"),
    FETCH("Fetch"),
    SIT("Sit"),
    ROLLOVER("Rollover"),
    SALUTE("Salute");

    private final String displayName;

    Trick(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

}

