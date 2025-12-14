package cn.edu.xmu.aftersale.mock;

/**
 * 此文件用于在本地进行售后模块的测试
 */
import cn.edu.xmu.aftersale.dto.ServiceOrderCreateDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/shops/{shopId}/aftersales/{id}/serviceorders")
public class MockServiceController {

    @PostMapping
    public void create(@PathVariable Long shopId,
                       @PathVariable Long id,
                       @RequestHeader("authorization") String token,
                       @RequestBody ServiceOrderCreateDTO dto) {
        System.out.println("[MOCK] 收到创建服务单, shopId=" + shopId + ", afterSalesId=" + id + ", dto=" + dto);
    }
}