package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
