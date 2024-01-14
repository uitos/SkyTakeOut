package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * 功能描述: 根据套餐id查询套餐喝菜品的关联关系
     * @param setmealId
     * @return java.util.List<com.sky.entity.SetmealDish>
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetmealId(Long setmealId);

    /**
     * 功能描述: 根据套餐id删除套餐和菜品的关联关系
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void delete(Long setmealId);

    /**
     * 功能描述: 根据套餐id集合批量删除套餐菜品关系表中的数据
     * @param setmealIds
     */
    void deleteBySetmealIds(List<Long> setmealIds);
}
