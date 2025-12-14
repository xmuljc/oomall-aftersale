package cn.edu.xmu.aftersale.controller;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;
import cn.edu.xmu.aftersale.dto.AuditAfterSalesDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import cn.edu.xmu.aftersale.service.AfterSalesService;

import java.util.Map;

@RestController
@RequestMapping("/shops/{shopId}/aftersales/{id}")
public class AfterSalesController {

    @Resource
    private AfterSalesService afterSalesService;

    @PutMapping("/confirm")
    public Map<String, Object> audit(
            @PathVariable Integer shopId,
            @PathVariable Integer id,
            @RequestHeader("authorization") String authorization,
            @RequestBody(required = false) AuditAfterSalesDTO dto) {


        if (!authorization.startsWith("Bearer ")) {
            return Result.fail(403, "非法token");
        }

        try {
            afterSalesService.audit(shopId.longValue(), id.longValue(), dto);
            return Result.ok();
        } catch (IllegalArgumentException | IllegalStateException e) {
            return Result.fail(503, e.getMessage());
        }
    }
}