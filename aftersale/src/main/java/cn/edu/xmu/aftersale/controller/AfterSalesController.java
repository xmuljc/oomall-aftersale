package cn.edu.xmu.aftersale.controller;

import cn.edu.xmu.aftersale.dto.AuditAfterSalesDTO;
import cn.edu.xmu.aftersale.service.AfterSalesService;
// import cn.edu.xmu.aftersale.controller.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops/{shopId}/aftersales")
public class AfterSalesController {

    @Resource
    private AfterSalesService afterSalesService;

    @PutMapping("/{id}/confirm")
    public Result audit(
            @PathVariable Long shopId,
            @PathVariable Long id,
            @RequestBody AuditAfterSalesDTO dto,
            @RequestHeader(value = "authorization", required = false) String token) {

        if (token == null || !token.startsWith("Bearer ")) {
            return Result.fail(401, "未登录或Token非法");
        }
        if (dto.getConfirm() == null) {
            return Result.fail(400, "审核结果不能为空");
        }

        try {
            afterSalesService.audit(
                    shopId,
                    id,
                    dto.getConfirm(),
                    dto.getConclusion(),
                    dto.getReason() // 把 reason 传进去
            );

            return Result.success();

        } catch (IllegalArgumentException e) {
            return Result.fail(404, e.getMessage());
        } catch (IllegalStateException e) {
            return Result.fail(400, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "内部错误: " + e.getMessage());
        }
    }
}