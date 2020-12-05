package cn.kgc.smbms.entity;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class User {
    private Long id;
    @NotEmpty(message = "用户名不能为空")
    private String userCode;
    private String userName;
    @Size(min = 6,max = 12,message = "密码长度在6-12位之间")
    private String userPassword;
    private Integer gender;
    private Date birthday;
    private String phone;
    private String address;
    private Integer userRole;
    private Integer age;
    private String userRoleName;
}
