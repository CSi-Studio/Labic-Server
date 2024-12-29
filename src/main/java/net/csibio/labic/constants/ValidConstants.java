package net.csibio.labic.constants;

import net.csibio.labic.utils.DateUtils;

import javax.validation.groups.Default;

/**
 * @author 顾遥
 */
public interface ValidConstants {
    /**
     * 其他机构名称
     */
    int INSTITUTION_TYPE_DESC_MAX = 50;
    /**
     * 机构名称
     */
    int INSTITUTION_NAME = 50;
    /**
     * 通知
     */
    int ANNOUNCE_CONTENT_MAX_LENGTH = 500;
    String ANNOUNCE_CONTENT_TOO_LONG = "通知的消息长度不能超过500字符";
    /**
     * 数据集
     */
    int DATA_SOURCE = 30;
    int DATA_NAME = 30;
    int DATA_TYPE = 10;
    int DATA_SPECIES = 10;
    int DATA_DESC = 300;
    /**
     * 数据包
     */
    int PACKAGE_NAME = 30;
    /**
     * 登录
     */
    int LOGIN_USERNAME = 50;
    int LOGIN_PASSWORD = 100;
    /**
     * 用户信息
     */
    int STUDENT_NAME = 36;
    int STUDENT_ID_NUMBER = 30;
    int STUDENT_UNIT = 50;
    int STUDENT_NUMBER_DD = 50;
    int STUDENT_SEX = 1;
    int STUDENT_PROFILE = 300;
    int STUDENT_STUDENT_ID = 100;
    /**
     * 任务
     */
    int TASK_NAME = 30;
    int TASK_TYPE = 10;
    int TASK_TASK_TYPE = 10;
    int TASK_DES = 1000;
    /**
     * 班级
     */
    int GRADE_CLASS_NAME = 30;
    int GRADE_CLASS_TEACHER_NAME = 36;
    int GRADE_CLASS_GRADE = 36;
    /**
     * 课程
     */
    int COURSE_NAME = 30;
    /**
     * 答案
     */
    int ANSWER_NAME = 30;
    int ANSWER_DATA_ID = 3000;
    int ANSWER_DESC = 300;
    /**
     * 试卷
     */
    int PAPER_HEAD_TITLE = 50;
    /**
     * 考试发布
     */
    int EXAM_TITLE_MAX_LEN = 64;
    int DCM_DESC = 300;
    int DCM_NAME = 30;
    int DCM_ID = 100;
    int EXAM_EVALUATION = 300;
    int COURSE_CODE = 100;
    int PAGINATION_PAGE_SIZE_MAX = 100;
    String OBJ_ID_UPDATE_MESSAGE = "更改数据必须有ID";
    int ANSWER_LABELS_LEN = 100;
    int ANSWER_LABELS_SINGLE_LEN = 50;
    String OBJ_ID_INSERT_MESSAGE = "插入数据必须无ID";
    int TOO_MUCH_LENGTH = 100000;
    String USER_IS_EXIST = "用户名已存在！";
    int STUDENT_STUDENT_ID_MIN = 5;
    String USER_NAME_NOT_NULL = "用户名不能为空";
    int USER_NAME_MAX = 32;
    String REAL_NAME_NOT_NULL = "真实姓名不能为空";
    int REAL_NAME_MAX = 32;
    String PASSWORD_NOT_NULL = "密码不能为空";
    int PASSWORD_MAX = 32;
    String PASSWORD_REGEX = "^\\s{0}$|^[\\w_-]{6,16}$";
    String PASSWORD_REGEX_MESSAGE = "密码可以是数字、字母、下划线和减号，长度6-16";
    String MOBILE_REGEX = "^\\s{0}$|^(?:(?:\\+|00)86)?1[3-9]\\d{9}$";
    String MOBILE_REGEX_MESSAGE = "手机号码格式不正确";
    String MOBILE_NOT_NULL = "手机号码不能为空";
    int USER_SEX_MAX = 3;
    String USER_SEX_MESSAGE = "用户性别格式错误";
    String MAX_ANALYSIS_LENGTH = "最大解析长度不超过200字";
    int DEPART_PARENT_ID_MAX = 32;
    String DEPART_NAME_NOT_NULL = "部门名称不能为空";
    int DEPART_ADDRESS_MAX = 256;
    int DEPART_NAME_MAX = 32;
    int USER_DESC = 64;
    String LOGIN_USERNAME_REGEX = "^\\s{0}$|^[\\w_-]{4,16}$";
    String LOGIN_USERNAME_REGEX_MESSAGE = "用户名可以是数字、字母、下划线和减号，长度4-16";
    String REAL_NAME_REGEX = "^([\\u4e00-\\u9fa5]{2,20}|[a-zA-Z.\\s]{2,20})$";
    String REAL_NAME_REGEX_MESSAGE = "真实姓名格式错误";
    /**
     * 部门
     */
    int DEPART_MAX = 100;
    int DEPART_MAX_DEPTH = 10;
    int DEPART_ZERO_COUNT = 2;
    String DEPART_TYPE_NOT_NULL = "机构类型选择不能为空";
    String DEPART_ALL_ACCOUNT_COUNT = "机构总帐号数不能为空";
    long DEPART_ALL_ACCOUNT_COUNT_MAX = 10000000;
    String DEPART_MOBILE_IS_NOT_NULL = "机构名称不能为空";
    String DEPART_ADMIN_NAME_IS_NOT_NULL = "机构管理员名称不能为空";
    String DEPART_EFFECTIVE_START_TIME_IS_NOT_NULL = "机构有效开始时间不能为空";
    String DEPART_EFFECTIVE_END_TIME_IS_NOT_NULL = "机构有效结束时间不能为空";
    int NAME_MAX = 32;
    String NAME_MAX_OUT = "名称超过了" + NAME_MAX + "个字符";
    int EDIT_FIELD = 1;
    String EDIT_FIELD_MESSAGE = "最少编辑字段" + EDIT_FIELD + "组";
    int EDIT_FIELD_LENGTH = 2;
    long VALID_COUNT = 0;
    String VALID_COUNT_OUT = "最小有效数字不能小于" + VALID_COUNT;
    String DEPART_UN_SET = "未选中部门";
    String QUESTION_BANK_NAME_IS_NOT_NULL = "题库名称不能为空";
    String QUESTION_BANK_ALL_COUNT_IS_NOT_NULL = "题库总题数不能为空";
    String UN_SET_STATUS = "未设置状态";
    String EXAM_PAPER_IS_NULL = "考试选择试卷为空";
    String EXAM_TITLE_PATTERN = "^[\\u4e00-\\u9fa5\\(\\)\\_\\-\\（\\）\\、\\:\\：\\'a-zA-Z0-9]{1," + EXAM_TITLE_MAX_LEN + "}$";
    String EXAM_TITLE_PATTERN_MESSAGE = "考试名称支持1-" + EXAM_TITLE_MAX_LEN + "位中英文、数字、特殊字符(_-()（）、:：')";
    String EXAM_TIMING_TYPE_IS_NULL = "考试开始类型为空";
    String EXAM_START_TIME_IS_NULL = "考试开始时间为空";
    String EXAM_TITLE_IS_NULL = "考试标题为空";
    String EXAM_EXAM_TIME_LONG_IS_NULL = "考试时长为空";
    String EXAM_USER_IDS_IS_NULL = "考试选择人员为空";
    String MOBILE_IS_EXIST = "手机号已经被注册";
    String INSERT_ERROR = "插入数据失败";
    String PARENT_ID_IS_NULL = "上级部门 id 为空";
    String QUESTION_TYPE_UN_KNOW = "该类型暂不支持";
    String QUESTION_TITLE_IS_EMPTY = "试题题干为空";
    String QUESTION_UN_SET_ANSWER = "试题未设置正确答案";
    String QUESTION_MARK_UN_SET = "标注题暂时不能配置";
    String UN_SIGN_PROTOCOL = "未签署平台协议";
    String DEPART_EXIST_PHONE = "该部门已经添加此号码";
    String QUESTION_BANK_TYPE_IS_NOT_NULL = "题库类型为空";
    String MECHANISM_ADMIN_CANNOT_HANDLE = "机构管理员不能使用";
    long TIME_OUT_GAP_MAX = 10;
    long TIME_OUT = 5;
    String NAME_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9]{1,20}$";
    String NAME_REGEX_MESSAGE = "名称只能是中文、英文、数字,长度在1-20";
    String NAME_IS_NULL = "名称为空";
    String TIME_LONG_IS_NULL = "时长为空";
    String START_NOW_IS_NULL = "开始模式选择为空";
    String UN_SELECT_PAPER = "未选择试卷";
    String UN_SELECT_TIME_TYPE = "未选择计时方式";
    long MIN_ACCOUNT_TYPE = 4;
    String UN_SELECT_ACCOUNT_TYPE = "不能选择此类账户";
    int USER_NAME_PATTERN_MAX = 20;
    String EMPNO_REGEX = "^[^ ]{0,16}$";
    String EMPNO_MESSAGE = "工号不能超过16位字符，且不含空格";
    String PAPER_NAME_REGEX = "^[\\u4e00-\\u9fa5\\(\\)\\_\\-\\（\\）\\、\\:\\：\\'a-zA-Z0-9]{1,32}$";
    String PAPER_NAME_MESSAGE = "试卷名称，支持1-32位中文、英文、数字、特殊符号(_-()（）、:：')字符";
    String QUESTION_BANK_NAME_REGEX = "^[\\u4e00-\\u9fa5\\(\\)\\_\\-\\（\\）\\、\\:\\：\\'a-zA-Z0-9]{1,32}$";
    String QUESTION_BANK_NAME_MESSAGE = "题库名称，支持1-32位中文、英文、数字、特殊符号(_-()（）、:：')字符";
    int MAX_QUERY_LENGTH = 64;
    String MAX_QUERY_MESSAGE = "最大查询长度不能超过" + MAX_QUERY_LENGTH;
    String DEPART_MAX_DEPTH_MESSAGE = "部门深度超过" + ValidConstants.DEPART_MAX_DEPTH;
    String EMPNO_REPEAT_ERROR = "工号已存在";
    String UN_SELECT_QUESTION = "未选择试题";
    String REGEX_ILLEGAL = "格式非法";
    String UN_SELECT_EXAM_SEND = "未选择考试人";
    int EXAM_SEND_CONTENT = 250;
    String EXAM_SEND_CONTENT_MESSAGE = "考试答题内容不能超过" + EXAM_SEND_CONTENT + "字符";
    String UN_SELECT_QUESTION_TYPE = "未选择题目类型";
    int ID_MAX = 32;
    String UN_SELECT_EXAM = "未选择考试";
    long IMG_MAX_LEN = 2 * 1024 * 1024;
    int URL_MAX = 1024;
    int QUESTION_ANALYSIS_MAX_LEN = 1000;
    String CORRECTING_FLAG_MESSAGE = "是否需要人工审批只能为0或1";
   int QUESTION_TITLE_MAX_LEN = 800;
    int QUESTION_OPTIONS_TEXT_MAX_LEN = 800;
    int UPLOAD_URL_MAX_LEN = 200;
    long USER_SEX_MIN = 0;
    String DEPART_EXIST_COMMA_MESSAGE = "部门名称存在英文逗号";
    String SCORE_REGEX = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])|0";
    String SCORE_REGEX_MESSAGE = "分数为正数或零";
    String QUESTION_TITLE_MAX_LEN_MESSAGE = "题干不能超过" + ValidConstants.QUESTION_TITLE_MAX_LEN + "字符";
    String QUESTION_OPTIONS_TEXT_MAX_LEN_MESSAGE = "选项文本不能超过" + ValidConstants.QUESTION_OPTIONS_TEXT_MAX_LEN + "字符";
    String QUESTION_ANALYSIS_MAX_LEN_MESSAGE = "题目解析不能超过" + ValidConstants.QUESTION_ANALYSIS_MAX_LEN + "字符";
    String CREATE_DEPART_NEED_PARENT_ID = "创建时上传部门 id 为空";
    String DEPART_NAME_PATTERN = "^[\\u4e00-\\u9fa5\\(\\)\\_\\-\\（\\）\\、\\:\\：\\'a-zA-Z0-9]{1,16}$";
    String DEPART_NAME_PATTERN_MESSAGE = "部门名称，支持1-16位中文、英文、数字、特殊符号(_-()（）、:：')字符";
    String DEPART_CREATE_ERROR = "部门创建失败";
    String EXCEL_EMPNO_REPEAT_ERROR = "表中存在重复工号";
    String QUESTION_RAN_MESSAGE = "题目随机只能为0或1";
    String OPTION_RAN_MESSAGE = "选项随机只能为0或1";
    String EXAM_USER_TYPE_MESSAGE = "考试人员类型只能为0或1";
    long VIDEO_MAX_LEN = 5L * 1024 * 1024 * 1024;
    long VIDEO_EXPIRE_TIME = 7* DateUtils.DAY_SECOND;
    int VIDEO_NAME_MAX_LENGTH = 50;
    int COURSEWARE_NAME_LEN = 50;
    String COURSE_NAME_IS_EMPTY = "课程名称不能为空";
    String COURSE_NAME_PATTERN = "^[\\u4e00-\\u9fa5\\(\\)\\_\\-\\（\\）\\、\\:\\：\\'a-zA-Z0-9]{1,64}$";
    String COURSE_NAME_PATTERN_MESSAGE = "课程名称为1-64位字、特殊字符(_-()（）、:：\\')";
    long PDF_MAX_LEN = 100L * 1024 * 1024;
    String APPLICANT_NAME_IS_EMPTY = "申请人姓名不能为空";
    String INSTITUTION_NAME_IS_EMPTY = "机构名称不能为空";
    String INSTITUTION_TYPE_IS_EMPTY = "机构类型不能为空";
    String INSTITUTION_ACCOUNT_QUANTITY_IS_EMPTY = "人员数量不能为空";
    long LIMIT_ENTER_EXAM_TIME_LONG_INT = 0;
    String LIMIT_ENTER_EXAM_TIME_LONG = "开始考试后最晚进入时间不能为负数";
    long LIMIT_SUBMIT_TIME_LONG_INT = 0;
    String LIMIT_SUBMIT_TIME_LONG = "开始考试后最早交卷时间不能为负数";

    interface UPDATE extends Default {
    }

    interface CREATE extends Default {
    }

    interface MECHANISM_CANNOT extends Default {
    }
}
