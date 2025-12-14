package cn.edu.xmu.aftersale.dto;

import lombok.Data;

@Data
public class AuditAfterSalesDTO {


    private Boolean confirm;   // true=通过 false=拒绝


    private String conclusion; // 审核意见


    private Integer type;      // 0换货 1退货 2维修
}