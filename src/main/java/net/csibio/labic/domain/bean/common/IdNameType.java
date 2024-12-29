package net.csibio.labic.domain.bean.common;

public record IdNameType(String id, String name,String type) {
    public IdNameType(String id, String name,String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String type() {
        return this.type;
    }
}

