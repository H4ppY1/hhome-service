package com.happy.hhome.service.product;

import com.happy.hhome.util.Result;

public interface Order {
    Result insertOrder();
    Result listOrder();
    Result getOrder();
}
