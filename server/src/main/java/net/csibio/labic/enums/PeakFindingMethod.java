package net.csibio.labic.enums;

public enum PeakFindingMethod {
    PROPRO("PROPRO"),
    MZMINE("MZMINE"),
    WAVELET("WAVELET"),
    LOCAL_MINIMUM("LOCAL_MINIMUM"),
    SAVITZKY_GOLAY("SAVITZKY_GOLAY"),
    IONS_SHAPE("IONS_SHAPE"),
    IONS_COUNT("IONS_COUNT"),
    ;
    String name;

    PeakFindingMethod(String name) {
        this.name = name;
    }

    public static PeakFindingMethod getByName(String name) {
        for (PeakFindingMethod method : values()) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
