package net.csibio.labic.domain.bean.common.Journal;

import lombok.Data;

import java.util.List;

@Data
public class Partition {

    Integer year;

    //JCR分区
    List<WosDesc> jcrList;

    //JCI分区
    List<WosDesc> jciList;

    //中科院分区
    List<ZkyDesc> zkyList;

}
