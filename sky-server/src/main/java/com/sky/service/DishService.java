package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

public interface DishService {
    /**
     * 功能描述: 新增菜品和对应的口味
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);
    /**
     * 功能描述: 菜品分页查询
     * @param dishPageQueryDTO
     * @return com.sky.result.PageResult
     */

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 功能描述: 菜品批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);
}
