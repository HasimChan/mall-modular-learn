package com.hasim.pojo;

import java.io.Serializable;

/**
 * @Description 用户权限类
 * @Author Hasim
 * @Date 2021/9/9 10:10
 * @Version 1.0
 */
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
