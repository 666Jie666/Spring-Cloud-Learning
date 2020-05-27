package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data               //为类提供读写属性
@AllArgsConstructor //为类提供全参构造
@NoArgsConstructor  //为类提供空参构造
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
