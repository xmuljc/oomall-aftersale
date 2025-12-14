-- 1. 如果表已存在，先删除（慎用，会清空数据）
DROP TABLE IF EXISTS after_sales_order;

-- 2. 建立新表（已包含 reason 字段）
CREATE TABLE after_sales_order(
                                  id BIGINT PRIMARY KEY COMMENT '主键ID',
                                  shop_id BIGINT NOT NULL COMMENT '店铺ID',
                                  customer_id BIGINT NOT NULL COMMENT '客户ID',
                                  order_id BIGINT NOT NULL COMMENT '关联的原订单ID',
                                  type INT DEFAULT 2 COMMENT '0换货 1退货 2维修',
                                  status INT DEFAULT 0 COMMENT '0已申请 1已同意 2已拒绝',
                                  conclusion VARCHAR(200) COMMENT '审核结论(同意/不同意)',
                                  reason VARCHAR(255) COMMENT '审核拒绝理由(只有拒绝时有值)',
                                  create_time DATETIME DEFAULT NOW(),
                                  update_time DATETIME DEFAULT NOW()
) COMMENT '售后单表';