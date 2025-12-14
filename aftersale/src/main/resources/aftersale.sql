CREATE TABLE after_sales_order(
                                  id BIGINT PRIMARY KEY,
                                  shop_id BIGINT NOT NULL,
                                  customer_id BIGINT NOT NULL,
                                  order_id BIGINT NOT NULL,
                                  type INT DEFAULT 2 COMMENT '0换货 1退货 2维修',
                                  status INT DEFAULT 0 COMMENT '0已申请 1已同意 2已拒绝',
                                  conclusion VARCHAR(200),
                                  create_time DATETIME DEFAULT NOW(),
                                  update_time DATETIME DEFAULT NOW()
);
