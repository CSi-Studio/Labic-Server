package net.csibio.labic.domain.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.csibio.labic.domain.BaseDO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Document("conference")
@Accessors(chain = true)
public class Conference extends BaseDO {

    @Id
    String id;

    @Indexed
    String name;

    @Indexed
    String type;

    String level;

    String sponsor;

    String address;

    //会议开始时间
    Date startDate;

    //会议结束时间
    Date endDate;

    @CreatedDate
    Date createDate;

    @LastModifiedDate
    Date lastModifiedDate;

    public ExampleMatcher buildMatcher() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写
                .withMatcher("title", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写// name 模糊匹配，忽略大小写
                .withMatcher("address", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写// name 模糊匹配，忽略大小写
                .withMatcher("level", match -> match.exact())
                .withMatcher("sponsor", match -> match.exact())
                .withMatcher("type", match -> match.exact())
                ;
        return matcher;
    }
}
