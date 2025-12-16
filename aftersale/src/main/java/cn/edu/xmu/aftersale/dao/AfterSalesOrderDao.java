package cn.edu.xmu.aftersale.dao;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;
import cn.edu.xmu.aftersale.dao.mapper.AfterSalesOrderMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class AfterSalesOrderDao {
    @Resource
    private AfterSalesOrderMapper mapper;

    public AfterSalesOrderBO selectById(Long id) {
        return mapper.selectById(id);
    }
    public void update(AfterSalesOrderBO bo) {
        mapper.updateById(bo);
    }
}
