package net.csibio.labic.constants;

public interface UserConstant {
    String MAN_SEX = "1";
    String WOMAN_SEX = "0";
    int MAN = 1;

    int WOMAN = 0;
    String DEFAULT_PASSWORD = "123456";
    String USER_DEFAULT_PASSWORD_KEY = "USER_DEFAULT_PASSWORD_KEY";
    String USER_NOT_FOUND = "用户不存在";
    String USERNAME_HAVE_EXIST = "该用户名已存在0000000000000000000000000000000000000000000000000000000";
    String USERNAME_UN_SET = "该用户名未设置00000000000000000000000000000000000";
    int SEX_UNSET = 3;
    String WOMAN_STR = "女";
    String MAN_STR = "男";

    /**
     * 数据库 sex 获取 excel sex
     * @param sex
     * @return
     */
    static String getSex(Integer sex) {
        if(sex==null){
            return SymbolConst.EMPTY;
        }
        if(sex==MAN){
            return MAN_STR;
        }
        if(sex ==WOMAN){
            return WOMAN_STR;
        }
        return SymbolConst.EMPTY;
    }
}
