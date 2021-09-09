package com.hasim.pojo;

import java.io.Serializable;

/**
 * @Description 用户权限-信息类
 * @Author Hasim
 * @Date 2021/9/9 10:12
 * @Version 1.0
 */
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer userId;
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
