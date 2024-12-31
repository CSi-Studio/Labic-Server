package net.csibio.labic.domain.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.csibio.labic.domain.BaseDO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Document("publication")
@Accessors(chain = true)
public class Publication extends BaseDO {

    @Id
    String id;

    @Indexed(unique = true)
    String doi;

    @Indexed
    String type;
    @Indexed
    String key;
    @Indexed
    String author;
    @Indexed
    String title;
    @Indexed
    String booktitle;
    @Indexed
    String journal;
    @Indexed
    String year;
    @Indexed
    String publisher;

    String month;
    String volume;
    String number;
    String pages;

    String chapter;
    String crossref;
    String editor;
    String eprint;
    String howPublished;
    String orginazation;
    String institution;
    String annote;
    String school;
    String series;

    String address;
    String edition;

    String note;
    String url;

    String language;

    @CreatedDate
    Date createDate;

    @LastModifiedDate
    Date lastModifiedDate;

}
