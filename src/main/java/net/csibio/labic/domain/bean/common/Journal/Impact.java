package net.csibio.labic.domain.bean.common.Journal;

import lombok.Data;

@Data
public class Impact {

    Integer year;
    Float if2Year; //两年影响因子
    Float if5Year; //五年影响因子
    Integer hIndex; //h-index
    Float selfRefRate; //自引率

}
