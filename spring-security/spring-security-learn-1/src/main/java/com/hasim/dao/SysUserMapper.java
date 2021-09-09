package com.hasim.dao;

import com.hasim.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author Hasim
 * @Date 2021/9/9 10:14
 * @Version 1.0
 */
@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where id = #{id}")
    SysUser selectById(Integer id);

    @Select("select * from sys_user where name = #{name}")
    SysUser selectByName(String name);
}
