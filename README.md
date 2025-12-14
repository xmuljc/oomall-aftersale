


##  一、修改
1.  **采用充血模型**
2.  **业务逻辑优化**
    * 重新梳理了审核流程，明确区分了“同意”与“拒绝”的处理路径。
3.  **参数列表优化**
4.  **与设计文档对齐**
    * 代码实现与标准顺序图基本保持一致，除了user参数。

---

##  二、运行


### 1. 数据库初始化

* **一**：运行 `src/main/resources/aftersale.sql`删除旧表插入新表（加入reason字段）
* **二**：运行 `src/main/resources/updatedate.sql`更新数据


### 2. 启动应用
运行：`cn.edu.xmu.aftersale.AfterSaleApplication`

### 3. 接口测试 
使用 IDEA 自带的 HTTP Client 进行测试：

1.  打开测试文件：`src/test/resources/aftersale-test.http`
2.  点击测试请求左侧的绿色运行按钮（测试“同意”或“拒绝”场景）。
3.  **查看结果**：如果测试通过，IDEA 控制台将显示如下界面：

<img width="413" height="237" alt="测试成功截图" src="https://github.com/user-attachments/assets/48deefa3-210a-48bf-b843-f2ab95205769" />

### 4. 结果验证
测试完成后，请检查数据库 `after_sales_order` 表：
* **若测试同意**：`status` 应变为 `1`，`conclusion` 为 "同意"。
* **若测试拒绝**：`status` 应变为 `2`，`reason` 字段应记录拒绝理由。
