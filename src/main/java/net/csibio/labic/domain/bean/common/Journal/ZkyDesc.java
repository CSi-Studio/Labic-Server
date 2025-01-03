package net.csibio.labic.domain.bean.common.Journal;

import lombok.Data;

import java.util.List;

@Data
public class ZkyDesc {

    String cnName;
    String enName;

    String category;
    String level;

    Boolean top;
    Boolean reviewer;

    List<ZkyDesc> sub;
}
