package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

public interface OrderService {
    /**
     * 功能描述: 用户下单
     * @param ordersSubmitDTO
     * @return com.sky.vo.OrderSubmitVO
     */

    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
