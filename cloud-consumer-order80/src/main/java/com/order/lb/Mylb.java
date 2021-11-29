package com.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Mylb implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getIndex(){

        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*******************当前次数" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {

        if (serviceInstanceList == null || serviceInstanceList.size() <= 0){
            return null;
        }

        int index = getIndex() % serviceInstanceList.size();

        return serviceInstanceList.get(index);
    }
}
