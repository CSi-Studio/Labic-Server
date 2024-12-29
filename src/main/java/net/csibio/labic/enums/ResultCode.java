package net.csibio.labic.enums;

import java.io.Serializable;

public enum ResultCode implements Serializable {

    /**
     * ******
     * 系统错误
     * *******
     */
    ERROR("SYSTEM_ERROR", "系统繁忙,请稍后再试!"),
    EXCEPTION("SYSTEM_EXCEPTION", "系统繁忙,稍后再试!"),
    IO_EXCEPTION("IO_EXCEPTION", "文件读写错误"),
    PARAMS_NOT_ENOUGH("PARAMS_NOT_ENOUGH", "入参不齐"),
    PARAMS_VALIDATE_ERROR("PARAMS_VALIDATE_ERROR", "入参校验失败"),
    CACHE_MISSING("CACHE_MISSING", "缓存未命中"),

    /**
     * ******
     * 常见通用错误
     * *******
     */
    OBJECT_CANNOT_BE_NULL("OBJECT_CANNOT_BE_NULL", "对象不能为空"),
    OBJECT_IS_EXISTED("OBJECT_IS_EXISTED", "对象已存在"),
    OBJECT_NOT_EXISTED("OBJECT_NOT_EXISTED", "对象不存在"),
    QUERY_ERROR("QUERY_ERROR", "获取数据失败"),
    INSERT_ERROR("INSERT_ERROR", "插入数据失败"),
    DUPLICATE_KEY_ERROR("DUPLICATE_KEY_ERROR", "插入数据失败,已有同名项存在"),
    SAVE_ERROR("SAVE_ERROR", "保存数据失败"),
    UPDATE_ERROR("UPDATE_ERROR", "更新数据失败"),
    DELETE_ERROR("DELETE_ERROR", "删除数据失败"),
    PARSE_ERROR("PARSE_ERROR", "解析错误"),
    ID_CANNOT_BE_NULL_OR_ZERO("ID_CANNOT_BE_NULL_OR_ZERO", "ID不能为空或者0"),
    LINE_IS_EMPTY("LINE_IS_EMPTY", "内容为空"),
    EXTRACT_FAILED("EXTRACT_FAILED", "解压缩失败"),
    UNAUTHORIZED_ACCESS("UNAUTHORIZED_ACCESS", "未经授权的非法访问"),

    /**
     * ******
     * 数据库
     * *******
     */
    DELETE_TARGET_ERROR("DELETE_TARGET_ERROR", "删除靶标失败"),
    DELETE_LIBRARY_ERROR("DELETE_LIBRARY_ERROR", "删除库失败"),
    DELETE_ANALYSE_DATA_ERROR("DELETE_ANALYSE_DATA_ERROR", "删除分析数据失败"),
    DELETE_ANALYSE_OVERVIEW_ERROR("DELETE_ANALYSE_OVERVIEW_ERROR", "删除分析总览失败"),
    DELETE_BLOCK_INDEX_ERROR("DELETE_BLOCK_INDEX_ERROR", "删除进样索引失败"),
    DELETE_RUN_ERROR("DELETE_RUN_ERROR", "删除进样失败"),
    DELETE_SET_ERROR("DELETE_SET_ERROR", "删除Set失败"),
    DELETE_PROJECT_ERROR("DELETE_PROJECT_ERROR", "删除项目失败"),
    DELETE_METHOD_ERROR("DELETE_METHOD_ERROR", "删除方案失败"),
    DELETE_TRACE_ERROR("DELETE_TRACE_ERROR", "删除任务失败"),
    DELETE_SPECTRA_ERROR("DELETE_SPECTRA_ERROR", "删除光谱失败"),

    /**
     * ******
     * user
     * *******
     */
    PHONE_OR_PASSWORD_ERROR("PHONE_OR_PASSWORD_ERROR", "电话或者密码错误"),
    USER_NOT_EXISTED("USER_NOT_EXISTED", "该用户不存在，请联系管理员录入"),
    ACCOUNT_LOCKED("ACCOUNT_LOCKED", "您的账号已被临时锁定，请15分钟以后再试"),
    USERNAME_OR_PASSWORD_ERROR("USERNAME_OR_PASSWORD_ERROR", "用户密码错误，错误次数超过5次会临时锁定账户"),
    USERNAME_OR_PASSWORD_LENGTH_MUST_LESS_THAN_25("USERNAME_OR_PASSWORD_LENGTH_MUST_LESS_THAN_25", "用户名或密码长度不得超过25个字符"),


    /**
     * ******
     * SQL-COMMON
     * *******
     */
    CONNECTION_URL_CANNOT_BE_EMPTY("CONNECTION_URL_CANNOT_BE_EMPTY", "数据库链接URL不能为空"),
    CONNECTION_FAILED("CONNECTION_FAILED", "数据库连接失败"),
    CONNECTION_SUCCESS("CONNECTION_SUCCESS", "数据库连接成功"),


    ;

    private static final long serialVersionUID = -799302222165012777L;
    private String code = "";
    private String message = "";

    /**
     * @param code
     * @param message
     */
    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message + "(" + code + ")";
    }

}
