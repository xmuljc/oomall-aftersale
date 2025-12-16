package cn.edu.xmu.aftersale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "cn.edu.xmu.aftersale.feign")
@MapperScan("cn.edu.xmu.aftersale.dao.mapper")
public class AfterSaleApplication {
    public static void main(String[] args) {
        //调试
        System.out.println(">>> AfterSaleApplication main start");
        SpringApplication.run(AfterSaleApplication.class, args);
        //调试
        System.out.println(">>> AfterSaleApplication main end");

    }
}
