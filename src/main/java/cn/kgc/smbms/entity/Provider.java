package cn.kgc.smbms.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Provider {
    private Integer id;
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;
    private String proPhone;
    private String proAddress;
    private String proFax;
    private Integer createdBy;
    private Date creationDate;
    private Date modifyDate;
    private Integer modifyBy;
    private String  billCode;
    private String productName;
    private Integer totalPrice;
    private Integer isPayment;
    private String companyLicPicPath;
    private String orgCodePicPath;

}
