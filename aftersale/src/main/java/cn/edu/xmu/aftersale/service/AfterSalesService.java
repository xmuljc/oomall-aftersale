package cn.edu.xmu.aftersale.service;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;
import cn.edu.xmu.aftersale.dao.AfterSalesOrderDao;
import cn.edu.xmu.aftersale.dto.AuditAfterSalesDTO;
import cn.edu.xmu.aftersale.service.strategy.AfterSalesHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class AfterSalesService {

    @Resource
    private AfterSalesOrderDao orderDao;
    @Resource
    private List<AfterSalesHandler> handlers;
    private static final Logger log = LoggerFactory.getLogger(AfterSalesService.class);

    @Transactional
    public void audit(Long shopId, Long id, AuditAfterSalesDTO dto) {
        AfterSalesOrderBO bo = orderDao.selectById(id);

        if (bo == null) throw new IllegalArgumentException("售后单不存在");
        if (!Objects.equals(bo.getShopId(), shopId)) {
            throw new IllegalArgumentException("店铺ID不匹配");
        }
        if (bo.getStatus() != 0) {
            throw new IllegalStateException("只能审核已申请状态的订单");
        }
        // 允许修改类型
        if (dto.getType() != null) bo.setType(dto.getType());
        // 审核结果
        if (Boolean.TRUE.equals(dto.getConfirm())) {
            bo.setStatus(1);
            for (AfterSalesHandler h : handlers) {
                if (h.support(bo.getType())) {
                    h.handlePass(bo);
                    break;
                }
            }
        } else {
            bo.setStatus(2);
        }
        bo.setConclusion(dto.getConclusion());
        orderDao.update(bo);
        log.info("[AFTER_SALES] 审核完成, id={}, confirm={}, type={}", id, dto.getConfirm(), bo.getType());
    }
}