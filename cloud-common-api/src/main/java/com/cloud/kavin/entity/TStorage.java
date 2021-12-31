package com.cloud.kavin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description t_storage
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-17
 */
@Data
public class TStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * product_id
    */
    private Long productId;

    /**
    * user
    */
    private Integer user;

    /**
    * total
    */
    private Integer total;

    /**
    * residue
    */
    private Integer residue;

    public TStorage() {}
}