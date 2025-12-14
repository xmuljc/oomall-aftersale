package cn.edu.xmu.aftersale.service.strategy.impl;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;
import cn.edu.xmu.aftersale.dto.ServiceOrderCreateDTO;
import cn.edu.xmu.aftersale.feign.ServiceOrderClient;   // 1. 修正拼写
import cn.edu.xmu.aftersale.service.strategy.AfterSalesHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

@Component
public class RepairAfterSalesHandler implements AfterSalesHandler {
    private static final Logger log = LoggerFactory.getLogger(RepairAfterSalesHandler.class);

    @Resource
    private ServiceOrderClient serviceOrderClient;   // 2. 修正变量名

    @Override
    public boolean support(Integer type) {
        return Integer.valueOf(2).equals(type);
    }

    @Override
    public void handlePass(AfterSalesOrderBO bo) {
        ServiceOrderCreateDTO dto = new ServiceOrderCreateDTO();
        dto.setType(0);                 // 维修的分类0上门 1寄件 2线下，以0为例
        ServiceOrderCreateDTO.Consignee c = new ServiceOrderCreateDTO.Consignee();
        //先写死
        c.setName("张三");
        c.setMobile("13812345678");
        c.setRegionId(123);
        c.setAddress("某某街道 101 号");
        dto.setConsignee(c);

        // 这里先写死
        String token = "Bearer 123";

        serviceOrderClient.createServiceOrder(bo.getShopId(), bo.getId(), token, dto);
        log.info("[REPAIR] 已调用创建服务单, shopId={}, afterSalesId={}", bo.getShopId(), bo.getId());
    }
}