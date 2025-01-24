package week2.enumerators;

public enum FishTank {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");
    private final String displayName;
    FishTank(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
}
