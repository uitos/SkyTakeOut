package com.sky.service;

import com.sky.dto.ShoppingCartDTO;

public interface ShoppingCartService {

    /**
     * 功能描述: 添加购物车
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
