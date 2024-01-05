package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 功能描述: 根据菜品id查询套餐id
     * @param dishIds
     * @return java.util.List<java.lang.Long>
     */

    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}
