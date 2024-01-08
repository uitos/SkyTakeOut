package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

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

    /**
     * 功能描述: 根据id擦汗寻菜品和对应的口味数据
     * @param id
     * @return com.sky.vo.DishVO
     */
    DishVO getByIdWithFlavor(Long id);

    /**
     * 功能描述: 起售或停售菜品
     * @param status
     * @param id
     */
    void enableOrDisable(Integer status, Long id);

    /**
     * 功能描述: 根据id修改菜品基本信息和对应的口味信息
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);
}
