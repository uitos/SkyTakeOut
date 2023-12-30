package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

public interface CategoryService {

    /**
     * 功能描述: 分类分页查询
     * @param categoryPageQueryDTO
     * @return : pageResult
     */

    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 功能描述: 新增分类
     * @param categoryDTO
     * @return :
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 功能描述: 启用禁用分类
     * @param status
     * @param id
     * @return :
     */
    void enableOrDisable(Integer status, long id);

    /**
     * 功能描述: 修改分类
     * @param categoryDTO
     * @return :
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 功能描述: 根据id删除分类
     * @param id
     * @return :
     */
    void deleteById(Long id);
}
