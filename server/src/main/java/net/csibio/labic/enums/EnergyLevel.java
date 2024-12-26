package net.csibio.labic.enums;

public enum EnergyLevel {

    Low("Low"),
    Med("Med"),
    High("High"),
    ;

    String name;

    EnergyLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EnergyLevel getByName(String name) {
        if (name == null) {
            return null;
        }
        for (EnergyLevel level : EnergyLevel.values()) {
            if (level.getName().equalsIgnoreCase(name)) {
                return level;
            }
        }
        if("medium".equalsIgnoreCase(name) || "mid".equalsIgnoreCase(name)){
            return EnergyLevel.Med;
        }
        return null;
    }
}
