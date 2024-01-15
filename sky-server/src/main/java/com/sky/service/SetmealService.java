package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    /**
     * 功能描述: 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);

    /**
     * 功能描述: 套餐分页查询
     * @param setmealPageQueryDTO
     * @return com.sky.result.PageResult
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 功能描述: 根据id查询套餐和套餐菜品关系
     * @param id
     * @return com.sky.vo.SetmealVO
     */
    SetmealVO getByIdWithDish(Long id);

    /**
     * 功能描述: 修改套餐
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     * 功能描述: 启用禁用套餐
     * @param status
     * @param id
     */
    void enableOrDisable(Integer status, long id);

    /**
     * 功能描述: 批量删除套餐
     * @param ids
     */
    void deleteBatch(List<Long> ids);
    /**
     * 功能描述: 条件查询
     * @param setmeal
     * @return java.util.List<com.sky.entity.Setmeal>
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 功能描述: 根据id查询菜品选项
     * @param id
     * @return java.util.List<com.sky.vo.DishItemVO>
     */
    List<DishItemVO> getDishItemById(Long id);
}
