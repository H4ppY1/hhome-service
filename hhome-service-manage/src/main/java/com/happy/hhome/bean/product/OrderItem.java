package com.happy.hhome.bean.product;

import javax.persistence.Table;

@Table(name = "orderitem")
public class OrderItem {
    private Integer itemId;
    private Integer productId;
    private Integer quantity;
    private Integer amount;
}
