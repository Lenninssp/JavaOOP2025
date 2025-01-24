package week2.enumerators;

public enum Moods {
    HAPPY("Happy"),
    SAD("Sad"),
    CONFUSED("Confused"),
    ANGRY("Angry"),
    NEUTRAL("Neutral");
    private String displayName;
    Moods(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
}
