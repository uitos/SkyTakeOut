package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
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

    /**
     * 功能描述: 批量保存套餐和菜品的关联关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);
}
