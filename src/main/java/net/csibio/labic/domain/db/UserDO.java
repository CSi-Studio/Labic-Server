package net.csibio.labic.domain.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.csibio.labic.constants.Sex;
import net.csibio.labic.domain.BaseDO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Document("user")
public class UserDO extends BaseDO {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    String id;

    /**
     * 用户名
     */
    @Indexed
    String username;

    /**
     * 真实姓名
     */
    @Indexed
    String realName;

    /**
     * 密码
     */
    String password;

    /**
     * 手机号（登录使用）
     */
    @Indexed
    String phone;

    /**
     * 性别
     */
    @Indexed
    Integer sex = Sex.UNSET;

    String salt;

    /**
     * 头像地址
     */
    String avatar;

    /**
     * 角色
     */
    String role;

    /**
     * 职称
     */
    String title;

    /**
     * 钉钉id
     */
    String ddId;

    /**
     * 微信id
     */
    String wxId;

    /**
     * 描述
     */
    String description;

    Date createDate;

    Date lastModifiedDate;
}
