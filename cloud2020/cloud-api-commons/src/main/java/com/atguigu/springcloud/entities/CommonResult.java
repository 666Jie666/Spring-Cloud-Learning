package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //为类提供读写属性
@AllArgsConstructor //为类提供全参构造
@NoArgsConstructor  //为类提供空参构造
public class CommonResult<T> {

    //404 not_found
    private Integer code;
    private String message;
    private T data;

    //定义两个参数的构造器（传入全参构造的data为空值）
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
