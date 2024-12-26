package net.csibio.labic.enums;

public enum OmicsType {

    Proteomics("Proteomics"),
    Metabolomics("Metabolomics"),
    ;

    String name;

    OmicsType(String name) {
        this.name = name;
    }
}
