package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    /**
     * 功能描述: 插入订单数据
     * @param orders
     */
    void insert(Orders orders);

    /**
     * 功能描述: 根据订单号查询订单
     * @param orderNumber
     * @return com.sky.entity.Orders
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 功能描述: 修改订单信息
     * @param orders
     */
    void update(Orders orders);
}
