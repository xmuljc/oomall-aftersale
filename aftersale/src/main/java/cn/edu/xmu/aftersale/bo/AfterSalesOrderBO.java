package cn.edu.xmu.aftersale.bo;

import cn.edu.xmu.aftersale.service.strategy.AuditStrategy;
import cn.edu.xmu.aftersale.service.strategy.AuditStrategyFactory;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AfterSalesOrderBO {
    private Long id;
    private Long shopId;
    private Long customerId;
    private Long orderId;
    private Integer type;
    private Integer status;
    private String conclusion;
    private String reason;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public void setStatus(int status) { this.status = status; }

    /**
     * 审核逻辑
     */
    public void audit(String conclusionIn, String reasonIn, boolean confirm) {
        this.updateTime = LocalDateTime.now();

        if (confirm) {
            // === 同意 ===
            this.status = 1;
            this.conclusion = "同意";
            this.reason = null; // 同意时清空理由

            // 执行策略
            AuditStrategy strategy = AuditStrategyFactory.getStrategy(this.type, this.conclusion);
            if (strategy != null) {
                strategy.execute(this, this.conclusion);
            }
        } else {
            // === 拒绝 ===
            this.status = 2;
            this.conclusion = "不同意";

            // 现在直接存入 reason 字段，不用拼接到 conclusion 了
            this.reason = reasonIn;
        }
    }
}