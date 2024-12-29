package net.csibio.labic.domain.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysUserQuery extends PageQuery {

    String id;
    List<String> ids;
    String username;
    String realName;
    String phone;
    Integer sex;

}
