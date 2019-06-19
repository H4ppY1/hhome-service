package com.happy.hhome.service;

import com.happy.hhome.util.Result;

import java.io.Serializable;

/**
 * @author haopeng17313
 */
public class BaseService {
    public Result success() {
        return new Result().ok();
    }

    public <T extends Serializable> Result<T> success(T reuslt) {
        return new Result().ok(reuslt);
    }
}
