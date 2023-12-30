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
}
