package net.csibio.labic.domain.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.csibio.labic.constants.Sex;
import net.csibio.labic.domain.BaseDO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document("user")
public class User extends BaseDO {

    /**
     * 主键
     */
    @Id
    String id;

    /**
     * 用户名
     */
    @Indexed(unique = true)
    String username;

    /**
     * 手机号（登录使用）
     */
    @Indexed
    String phone;

    /**
     * 性别
     */
    @Indexed
    String sex = Sex.Unset;

    /**
     * 主要称呼
     */
    @Indexed
    String name;

    /**
     * 次要称呼
     */
    @Indexed
    String alias;

    /**
     * 代号
     */
    @Indexed
    String code;

    /**
     * 主要主管ID
     */
    @Indexed
    String mainBossId;

    /**
     * 主要主管名字
     */
    String mainBossName;

    /**
     * 次要主管ID
     */
    @Indexed
    String minorBossId;

    /**
     * 次要主管名字
     */
    String minorBossName;

    /**
     * 邮箱
     */
    String email;

    /**
     * orcid
     */
    String orcid;

    /**
     * 个人网站
     */
    String personalUrl;

    /**
     * 个人Github
     */
    String github;

    /**
     * 身份证号码
     */
    String idNumber;

    /**
     * 护照号码
     */
    String passportNumber;

    /**
     * 密码
     */
    String password;

    /**
     * 加密用盐
     */
    String salt;

    /**
     * 头像地址
     */
    String avatar;

    /**
     * 角色
     */
    List<String> roles;

    /**
     * 职称
     */
    String jobTitle;

    /**
     * 钉钉id
     */
    String dingtalk;

    /**
     * 微信id
     */
    String wechat;

    /**
     * 标签
     */
    List<String> tags;

    /**
     * 个人简介
     */
    String description;

    @CreatedDate
    Date createDate;

    @LastModifiedDate
    Date lastModifiedDate;
}
