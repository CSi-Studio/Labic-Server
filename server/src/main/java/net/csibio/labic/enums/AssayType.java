package net.csibio.labic.enums;

public enum AssayType {

    Clinical("Clinical"),
    Animal("Animal"),
    Plant("Plant"),
    Cell("Cell"),
    Mix("Mix"),
    Benchmark("Benchmark"),
    Test("Test")
    ;

    String name;

    AssayType(String name) {
        this.name = name;
    }
}
