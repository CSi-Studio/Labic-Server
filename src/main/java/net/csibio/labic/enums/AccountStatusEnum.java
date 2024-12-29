package net.csibio.labic.enums;

/**
 * 账户状态枚举
 *
 * @author 顾遥
 */
public enum AccountStatusEnum {
    /**
     * 未注册
     */
    UNREGISTERED(0, "未注册"),
    /**
     * 已注册
     */
    REGISTERED(1, "已注册"),
    /**
     * 冻结
     */
    FROZEN(2, "冻结"), UN_SET(3, "未设置");

    final int code;
    final String msg;

    AccountStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getUserStatusStr(Integer code) {
        if (code == null) {
            return null;
        }
        for (AccountStatusEnum value : AccountStatusEnum.values()) {
            if (value.code == code) {
                return value.getMsg();
            }
        }
        return null;

    }

    public static Integer getUserStatusCode(String msg) {
        if (msg == null) {
            return null;
        }
        for (AccountStatusEnum value : AccountStatusEnum.values()) {
            if (value.msg.equals(msg)) {
                return value.getCode();
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
