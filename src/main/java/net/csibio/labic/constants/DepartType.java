package net.csibio.labic.constants;

public enum DepartType {
    INSTITUTION(1, "机构"),
    REGISTER_EXAM(2, "考试"),;
    private Integer code;
    private String desc;

    DepartType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
