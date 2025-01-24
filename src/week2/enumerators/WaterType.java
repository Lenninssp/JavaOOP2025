package week2.enumerators;

public enum WaterType {
    FRESHWATER("Freshwater"),
    SALTWATER("Saltwater");

    public final String displayName;
    WaterType(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }

}
