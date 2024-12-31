package net.csibio.labic.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.csibio.labic.constants.Sex;
import net.csibio.labic.domain.BaseDO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserVO extends BaseDO {

    String id;

    String username;

    String phone;

    String sex;

    String enName;

    String cnName;

    String email;

    List<String> tags;

    String orcid;

    String personalUrl;

    String github;

    String idNumber;

    String passportNumber;

    String avatar;

    String role;

    String jobTitle;

    String dingtalk;

    String wechat;

    String description;
}
