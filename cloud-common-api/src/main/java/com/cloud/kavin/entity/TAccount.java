package com.cloud.kavin.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description t_account
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-17
 */
@Data
public class TAccount implements Serializable {

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
    * user
    */
    private BigDecimal user;

    /**
    * total
    */
    private BigDecimal total;

    /**
    * residue
    */
    private Integer residue;

    public TAccount() {}
}