package com.cloud.kavin.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description t_order
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-17
 */
@Data
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * user_id
    */
    private Long userId;

    /**
    * product_id
    */
    private Long productId;

    /**
    * count
    */
    private Integer count;

    /**
    * money
    */
    private BigDecimal money;

    /**
    * status
    */
    private Integer status;

    public TOrder() {}
}