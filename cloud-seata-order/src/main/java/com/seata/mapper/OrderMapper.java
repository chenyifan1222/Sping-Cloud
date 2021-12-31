package com.seata.mapper;

import com.cloud.kavin.entity.Payment;
import com.cloud.kavin.entity.TOrder;

public interface OrderMapper {

    public TOrder getUserById(Long id);

    public int saveUser(TOrder order);
}
