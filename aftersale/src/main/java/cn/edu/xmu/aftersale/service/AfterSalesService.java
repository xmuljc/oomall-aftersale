package cn.edu.xmu.aftersale.service;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;
import cn.edu.xmu.aftersale.dao.AfterSalesOrderDao;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Slf4j
@Service
public class AfterSalesService {

    @Resource
    private AfterSalesOrderDao orderDao;

    @Transactional
    public void audit(Long shopId, Long id,
                      Boolean confirm,
                      String conclusion,
                      String reason) {

        //检验状态
        AfterSalesOrderBO bo = orderDao.selectById(id);
        if (bo == null) throw new IllegalArgumentException("售后单不存在");
        if (!Objects.equals(bo.getShopId(), shopId)) throw new IllegalArgumentException("店铺ID不匹配");
        if (bo.getStatus() != 0) throw new IllegalStateException("只能审核已申请状态的订单");

        // BO 负责处理业务逻辑
        bo.audit(conclusion, reason, Boolean.TRUE.equals(confirm));

        //持久化
        orderDao.update(bo);

        log.info("[Service] 审核完成: boId={}, 结果={}, reason={}", id, confirm, reason);
    }
}