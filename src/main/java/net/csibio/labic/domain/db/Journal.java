package net.csibio.labic.domain.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.csibio.labic.domain.BaseDO;
import net.csibio.labic.domain.bean.common.Journal.Impact;
import net.csibio.labic.domain.bean.common.Journal.Partition;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

@EqualsAndHashCode(callSuper = true)
@Data
@Document("journal")
@Accessors(chain = true)
public class Journal extends BaseDO {

    @Id
    String id;

    @Indexed
    String name;

    @Indexed
    String abbrName;

    @Indexed
    String printIssn;
    @Indexed
    String electronicIssn;
    @Indexed
    String linkingIssn;

    //预警期刊
    Boolean warning;
    Boolean reviewer;

    String url;

    String publisher;

    String country;

    String startYear;

    //历年影响因子
    List<Impact> ifList;
    List<Partition> partitionList;

    @CreatedDate
    Date createDate;

    @LastModifiedDate
    Date lastModifiedDate;

    public ExampleMatcher buildMatcher() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写
                .withMatcher("abbrName", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写// name 模糊匹配，忽略大小写
                .withMatcher("warning", match -> match.exact())
                .withMatcher("publisher", match -> match.exact())
                .withMatcher("printIssn", match -> match.exact())
                .withMatcher("electronicIssn", match -> match.exact())
                .withMatcher("linkingIssn", match -> match.exact())
                ;
        return matcher;
    }
}
