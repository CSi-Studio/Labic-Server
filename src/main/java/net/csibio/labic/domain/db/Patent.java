package net.csibio.labic.domain.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.csibio.labic.domain.BaseDO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Document("patent")
@Accessors(chain = true)
public class Patent extends BaseDO {

    // 专利ID
    @Indexed
    String id;

    @Indexed
    String patentId;

    // 专利标题
    @Indexed
    String title;

    // 专利摘要
    String abstractText;

    // 发明人
    String inventors;

    // 申请人
    String applicants;

    // 申请日期
    Date applicationDate;

    // 公开日期
    Date publicationDate;

    // 专利类型（例如：发明专利、实用新型专利、外观设计专利）
    String patentType;

    // 专利状态（例如：申请中、已授权、已过期）
    String status;

    // 国际专利分类号（IPC）
    String ipcCode;

    // 国家/地区代码（例如：CN, US, EP）
    String countryCode;

    // 专利文件链接
    String documentLink;

    @CreatedDate
    Date createDate;

    @LastModifiedDate
    Date lastModifiedDate;

    public ExampleMatcher buildMatcher() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("inventors", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写
                .withMatcher("applicants", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写// name 模糊匹配，忽略大小写
                .withMatcher("title", match -> match.contains().ignoreCase()) // name 模糊匹配，忽略大小写// name 模糊匹配，忽略大小写
                .withMatcher("patentId", match -> match.exact())
                .withMatcher("patentType", match -> match.exact())
                .withMatcher("status", match -> match.exact())
                .withMatcher("ipcCode", match -> match.exact())
                .withMatcher("countryCode", match -> match.exact())
                ;
        return matcher;
    }

}
