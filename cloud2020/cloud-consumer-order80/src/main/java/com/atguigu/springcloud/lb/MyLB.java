package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component  //把普通pojo实例化到Spring容器
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;    //当前值
        int next;       //累加数
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1; //2147483647是整型的最大取值
        } while (!this.atomicInteger.compareAndSet(current, next)); //当前值和累加数相同，返回true，跳出循环
        System.out.println("******第几次访问，次数next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
