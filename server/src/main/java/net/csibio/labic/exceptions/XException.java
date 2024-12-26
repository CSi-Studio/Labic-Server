package net.csibio.labic.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.csibio.labic.enums.ResultCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class XException extends Exception {

    String code;

    String message;

    List<String> errorList;

    public XException(String errorMsg) {
        this.message = errorMsg;
    }

    public XException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public XException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public XException(ResultCode resultCode, List<String> errorList) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.errorList = errorList;
    }
}
