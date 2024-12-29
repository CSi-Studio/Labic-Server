package net.csibio.labic.domain.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class LoginVO implements Serializable {
    private static final long serialVersionUID = -6849794470754667710L;

    private String id;
    private String username;
    private String password;
    private Boolean autoLogin;
    private Integer accountType;

}
