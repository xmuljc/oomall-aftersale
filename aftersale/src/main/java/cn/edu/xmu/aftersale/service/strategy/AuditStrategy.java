package cn.edu.xmu.aftersale.service.strategy;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;

public interface AuditStrategy {

    // 匹配规则
    boolean match(Integer type, String conclusion);
    // 执行策略
    void execute(AfterSalesOrderBO bo, String conclusion);
}