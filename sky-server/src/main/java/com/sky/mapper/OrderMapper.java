package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.vo.OrderStatisticsVO;
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

    /**
     * 功能描述: 分页条件查询并按下单时间排序
     *
     * @param ordersPageQueryDTO
     * @return com.github.pagehelper.Page<com.sky.entity.Orders>
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 功能描述:  各个状态的订单数量统计
     * @return com.sky.vo.OrderStatisticsVO
     */
    @Select("select count(id) from orders where status = #{status}")
    Integer countStatus(Integer status);


    /**
     * 功能描述: 根据id查询订单信息
     * @param id
     * @return com.sky.entity.Orders
     */
    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);
}
