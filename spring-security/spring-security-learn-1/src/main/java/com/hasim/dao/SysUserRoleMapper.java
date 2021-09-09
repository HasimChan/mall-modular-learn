package com.hasim.dao;

import com.hasim.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description 用户信息 - 权限表 mapper
 * @Author Hasim
 * @Date 2021/9/9 10:17
 * @Version 1.0
 */
@Mapper
public interface SysUserRoleMapper {
    @Select("select * from sys_user_role where user_id = #{userId}")
    List<SysUserRole> listByUserId(Integer userId);
}
