package cn.edu.xmu.aftersale.service.strategy;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;

/**
 * 策略接口：不同售后类型实现各自“审核通过”后的动作
 * 新增类型时，只需写一个新实现类，并加上 @Component 即可
 */
public interface AfterSalesHandler {
    boolean support(Integer type);
    void handlePass(AfterSalesOrderBO bo);

}
