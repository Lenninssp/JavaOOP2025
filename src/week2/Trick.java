package week2;

public enum Trick {
    JUMP("Jump"),
    FETCH("Fetch"),
    SIT("Sit"),
    ROLLOVER("Rollover");

    private final String displayName;

    Trick(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

}