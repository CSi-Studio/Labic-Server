package net.csibio.labic.enums;

public enum Polarity {

    Negative("NEGATIVE"),
    Positive("POSITIVE"),
    ;

    String name;

    Polarity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Polarity getByName(String name) {
        if(name == null){
            return null;
        }
        for (Polarity polarity : Polarity.values()) {
            if (polarity.getName().equalsIgnoreCase(name)) {
                return polarity;
            }
        }
        return null;
    }
}
