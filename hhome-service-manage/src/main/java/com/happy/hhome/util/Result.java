package com.happy.hhome.util;

import java.io.Serializable;

/**
 * @author haopeng17313
 */
public class Result<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Integer SUCCESS = 0;
    public static final Integer FAIL = 1;
    private Integer errorNo;
    private String errorCode;
    private String errorInfo;
    private T result;

    public static Result success() {
        return new Result(SUCCESS, "", null);
    }
    public static Result  fail(String errorInfo) {
        return new Result(FAIL, errorInfo, null);
    }

    public Result ok() {
        return new Result(SUCCESS, "", null);
    }
    public Result ok(T result) {
        return new Result(SUCCESS, "", result);
    }

    public Result() {
        this(SUCCESS, "", null);
    }

    public Result(T result) {
        this(SUCCESS, "", result);
    }

    public Result(String errorCode, String errorInfo, T result) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
        this.result = result;
    }

    public Result(Integer errorNo, String errorInfo, T result) {
        this.errorCode = errorNo.toString();
        this.errorInfo = errorInfo;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(Integer errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
