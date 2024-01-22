package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    /**
     * 功能描述: 批量插入订单明细数据
     * @param orderDetailList 
     */
    void insertBatch(List<OrderDetail> orderDetailList);

    /**
     * 功能描述: 根据订单id查询订单明细
     * @param OrderId
     * @return java.util.List<com.sky.entity.OrderDetail>
     */
    @Select("select * from order_detail where order_id = #{OrderId}")
    List<OrderDetail> getByOrderId(Long OrderId);
}
