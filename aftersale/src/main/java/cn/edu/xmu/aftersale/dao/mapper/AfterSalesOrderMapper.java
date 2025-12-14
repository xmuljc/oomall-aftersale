package cn.edu.xmu.aftersale.dao.mapper;

import cn.edu.xmu.aftersale.bo.AfterSalesOrderBO;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface AfterSalesOrderMapper {
    AfterSalesOrderBO selectById(@Param("id") Long id);
    void updateById(@Param("bo") AfterSalesOrderBO bo);
}
