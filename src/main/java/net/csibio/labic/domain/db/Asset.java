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
@Document("asset")
@Accessors(chain = true)
public class Asset extends BaseDO {

    @Id
    String id;

    //资产编号
    @Indexed
    String code;

    //出厂编号
    @Indexed
    String serialNumber;

    //资产名称
    @Indexed
    String name;

    //资产类型
    @Indexed
    String type;

    //资产状态
    @Indexed
    String status;

    //资产归属人
    @Indexed
    String ownerId;
    //资产归属人真名
    String ownerName;

    //资产使用人
    @Indexed
    String userId;
    //资产使用人真名
    String userName;

    //单价
    String unitPrice;

    //存放地址
    String address;

    //品牌
    String brand;

    //型号
    String model;

    //规格
    String specification;

    //合同编号
    String contract;

    //销售商
    String retailer;

    //财政大类
    String finCategory;

    //财政分类
    String finClass;

    //财政分类名称
    String finClassName;

    //验收日期
    Date acceptDate;

    @CreatedDate
    Date createDate;

    @LastModifiedDate
    Date lastModifiedDate;

    public ExampleMatcher buildMatcher() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("code", match -> match.contains().ignoreCase())
                .withMatcher("serialNumber", match -> match.contains().ignoreCase())
                .withMatcher("name", match -> match.contains().ignoreCase())
                .withMatcher("status", match -> match.exact())
                .withMatcher("type", match -> match.exact())
                .withMatcher("ownerId", match -> match.exact())
                .withMatcher("userId", match -> match.exact())
                ;
        return matcher;
    }
}
