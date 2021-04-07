package com.ahzeng.queuingSys.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Result<T> {
    private Integer code;
    private T data;
    private String message;

    private Result(T data) {
        this.code = 0;
        this.data = data;
        this.message= message;
    }

    private Result(CodeMsg codeMsg) {
        this.message=codeMsg.getMsg();
        this.code=codeMsg.getCode();
    }

    //通过构造方法只需要传data就可以
    public static <T>Result<T> success( T data ){
        return new Result<>(data);
    }

    // 这里使用codeMsg 是因为返回结果的是code码不是固定的
    public static <T>Result<T> error(CodeMsg codeMsg){
        if (codeMsg == null) {
            log.warn("codeMsg is null");
            return null;
        }
        return new Result<T>(codeMsg);
    }
}

