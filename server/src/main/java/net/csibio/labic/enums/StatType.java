package net.csibio.labic.enums;

public enum StatType {

    Global_Total("Global_Total"),
    Project("Project");

    String name;

    StatType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
