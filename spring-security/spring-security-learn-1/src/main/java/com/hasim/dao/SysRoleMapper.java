package com.hasim.dao;

import com.hasim.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description 用户权限表 mapper
 * @Author Hasim
 * @Date 2021/9/9 10:16
 * @Version 1.0
 */
@Mapper
public interface SysRoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Integer id);
}
