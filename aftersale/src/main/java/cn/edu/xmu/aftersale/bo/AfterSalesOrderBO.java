package cn.edu.xmu.aftersale.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class AfterSalesOrderBO {

    private Long id;


    private Long shopId;

    private Long customerId;

    private Long orderId;




    private Integer type;   // 0换货 1退货 2维修


    public void setStatus(int status) {
        this.status = status;
    }

    private Integer status; // 0已申请 1已同意 2已拒绝


    private String conclusion;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}