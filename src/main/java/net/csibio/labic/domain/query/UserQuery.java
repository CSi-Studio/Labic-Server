package net.csibio.labic.domain.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserQuery extends PageQuery {

    String id;
    List<String> ids;
    String username;
    String realName;
    String phone;
    Integer sex;
}
