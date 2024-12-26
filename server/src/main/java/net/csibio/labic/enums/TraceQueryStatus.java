package net.csibio.labic.enums;

/**
 * @author guyao
 * @version 1.0
 * @description: TODO
 * @date 2023/12/20 9:49
 */
public enum TraceQueryStatus {

    NORMAL(0, "正常"),
    PROJECT_ANALYZE(1, "项目分析"),

    ;

    private final int code;
    private final String desc;

    TraceQueryStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
