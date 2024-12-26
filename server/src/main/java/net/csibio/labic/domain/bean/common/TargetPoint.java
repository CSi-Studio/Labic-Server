package net.csibio.labic.domain.bean.common;

import lombok.Data;

@Data
public class TargetPoint {

    String id;
    String name;
    Double mz;
    Double rt;

    public TargetPoint() {}
    public TargetPoint(String id, String name, Double mz, Double rt) {
        this.id = id;
        this.name = name;
        this.mz = mz;
        this.rt = rt;
    }
}
