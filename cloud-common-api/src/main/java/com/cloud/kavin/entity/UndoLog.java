package com.cloud.kavin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description undo_log
 * @author zhengkai.blog.csdn.net
 * @date 2021-12-17
 */
@Data
public class UndoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * branch_id
    */
    private Long branchId;

    /**
    * xid
    */
    private String xid;

    /**
    * context
    */
    private String context;

    /**
    * rollback_info
    */
    private String rollbackInfo;

    /**
    * log_status
    */
    private Integer logStatus;

    /**
    * log_created
    */
    private Date logCreated;

    /**
    * log_modified
    */
    private Date logModified;

    public UndoLog() {}
}