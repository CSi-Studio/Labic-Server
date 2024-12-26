package net.csibio.labic.enums;

public enum TimeUnit {

    MINUTE("MINUTE"),
    SECOND("SECOND"),
    ;

    String name;

    TimeUnit(String name) {
        this.name = name;
    }

    public static TimeUnit getByName(String name) {
        for (TimeUnit status : values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
