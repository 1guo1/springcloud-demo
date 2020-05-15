package com.guo.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dell on 2020/3/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    /**
     * 定义两个参数的
     * @param code
     * @param message
     */
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
