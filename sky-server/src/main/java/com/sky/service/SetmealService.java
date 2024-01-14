package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

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
}
