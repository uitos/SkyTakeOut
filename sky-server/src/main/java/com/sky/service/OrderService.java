package com.sky.service;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;

public interface OrderService {
    /**
     * 功能描述: 用户下单
     * @param ordersSubmitDTO
     * @return com.sky.vo.OrderSubmitVO
     */

    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 功能描述: 订单支付
     * @param ordersPaymentDTO
     * @return com.sky.vo.OrderPaymentVO
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 功能描述: 修改订单状态
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    /**
     * 功能描述: 订单搜索
     * @param ordersPageQueryDTO
     * @return com.sky.result.PageResult
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 功能描述:  各个状态的订单数量统计
     * @return com.sky.vo.OrderStatisticsVO
     */
    OrderStatisticsVO statistics();
}
