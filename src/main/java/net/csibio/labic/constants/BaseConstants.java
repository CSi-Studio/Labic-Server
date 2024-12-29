package net.csibio.labic.constants;

/**
 * 基础的枚举类
 *
 * @author 顾遥
 */
public interface BaseConstants {
    String STATUS_SUCCESS = "SUCCESS";
    String STATUS_FAILED = "FAIL";
    String TANZHI_STATIC_PATH = "static\\static\\";
    /**
     * 数据删除前缀
     */
    String DATA_DELETE_STR = "$已删除$";
    String DATA_DELETE_STR_ESCAPE = "\\$已删除\\$";
    String COLLECT_OK_STR = "已收藏";
    String COLLECT_NO_STR = "未收藏";
    String PARENTS = "parents";
    /**
     * Sse初始连接数
     */
    Integer SSE_INITIAL_CLIENTS = 15;
    /**
     * 未删除
     */
    Integer UN_DELETE = 0;
    /**
     * 已删除
     */
    Integer DELETED = 1;
    /**
     * 否
     */
    Integer NO = 0;
    /**
     * 是
     */
    String ON = "Y";
    String OFF = "N";
    Integer OK = 1;
    String ASC = "1";
    String DESC = "0";
    Integer UN_ALLOCATED = 0;
    Integer HALF_ALLOCATED = 1;
    Integer ALLOCATED = 2;
    Integer STATUS_3 = 3;
    String USER_UN_EXIST = "该用户不存在";
    String UNDEFINED = "undefined";
    String MAN = "1";
    String WOMAN = "0";
    Integer All = -1;
    int INIT_COUNT = 0;
    int ARRAY_INIT_LENGTH = 0;
    int ARRAY_ELLIPSIS_LENGTH = 50;
    String INIT_STRING = "N";
    String DATA_NAME_IS_NOT_EXIST = "数据名称不存在";
    String EXAM_NAME_IS_NOT_EXIST = "考试名称不存在";
    String UNSET_STR = "0";
    int INIT_LENGTH = 1;
    boolean TRUE = true;
    boolean FALSE = false;
    String NONE = "NONE";
    int SINGLE_LENGTH = 1;
    int MAX_ANALYSIS_LENGTH = 200;
    String CH_YES = "是";
    int INIT_MAP_LENGTH = 32;
    String CAN_NOT_KEY = "--41185454SAD3Q1RE";
    CharSequence FILL_NEED_KNOWN = "填写须知";
    String CH_NO = "否";
    String NO_BIND_PAPER = "没有家属试卷";
    String TANZHI_URL = "https://tanzhi.net.cn";
}
