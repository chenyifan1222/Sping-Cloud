package com.seata.service;

import com.cloud.kavin.entity.TOrder;
import com.seata.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    OrderMapper orderMapper;

    public TOrder getUserById(Long id) {
        return orderMapper.getUserById(id);
    }

    public int saveUser(TOrder payment) {
        return orderMapper.saveUser(payment);
    }
}
