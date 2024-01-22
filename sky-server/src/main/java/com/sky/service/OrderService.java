package com.sky.service;

import com.sky.dto.*;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

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

    /**
     * 功能描述: 查询订单详情
     * @param id
     * @return com.sky.vo.OrderVO
     */
    OrderVO details(Long id);

    /**
     * 功能描述: 接单
     * @param ordersConfirmDTO
     */
    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    /**
     * 功能描述: 拒单
     * @param ordersRejectionDTO
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO) throws Exception;
}
