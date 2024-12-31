package net.csibio.labic.domain.query;

import lombok.Data;
import lombok.experimental.Accessors;
import net.csibio.labic.constants.SymbolConst;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = -8745138167696978267L;

    int current;
    int pageSize;
}
