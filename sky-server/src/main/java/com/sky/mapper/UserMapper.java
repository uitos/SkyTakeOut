package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {
    /**
     * 功能描述: 根据openid查询用户
     * @param openid
     * @return com.sky.entity.User
     */
    @Select("select * from user where openid = #{openid}")
    public User getOpenid(String openid);

    /**
     * 功能描述: 插入数据
     * @param user
     */
    void insert(User user);

    /**
     * 功能描述: 根据id查询用户
     * @param id
     * @return com.sky.entity.User
     */
    @Select("select * from user where id = #{id}")
    User getById(Long id);

    /**
     * 功能描述: 动态查询用户数量
     * @param map
     * @return java.lang.Integer
     */
    Integer countByMap(Map map);
}
