package com.hasim.service;

import com.hasim.dao.SysRoleMapper;
import com.hasim.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Hasim
 * @Date 2021/9/9 10:19
 * @Version 1.0
 */
@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id) {
        return roleMapper.selectById(id);
    }
}
