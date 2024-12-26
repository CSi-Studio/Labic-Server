package net.csibio.labic.enums;

public enum IonizationMod {

    ESI("ESI"),
    EI("EI"),
    ;

    String name;

    IonizationMod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static IonizationMod getByName(String name) {
        for (IonizationMod ionizationMod : IonizationMod.values()) {
            if (ionizationMod.getName().equalsIgnoreCase(name)) {
                return ionizationMod;
            }
        }
        return null;
    }
}
