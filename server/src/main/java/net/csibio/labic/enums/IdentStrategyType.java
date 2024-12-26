package net.csibio.labic.enums;

public enum IdentStrategyType {

    NEAREST_RT("NEAREST_RT"),
    HIGHEST_SCORE("HIGHEST_SCORE"),
    HIGHEST_INTENSITY("HIGHEST_INTENSITY"),
    ;
    String name;

    IdentStrategyType(String name) {
        this.name = name;
    }


    public static IdentStrategyType getByName(String name) {
        for (IdentStrategyType identStrategyType: values()) {
            if (identStrategyType.getName().equals(name)) {
                return identStrategyType;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }
}
