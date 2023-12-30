package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述:分类管理
 */
@RestController
@Slf4j
@RequestMapping("/admin/category")
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 功能描述: 分类分页查询
     * @param categoryPageQueryDTO
     * @return :
     */

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分类分页查询，参数为：{}",categoryPageQueryDTO);
        PageResult pageResult =  categoryService.pageQuery(categoryPageQueryDTO);

        return Result.success(pageResult);
    }
    /**
     * 功能描述: 新增分类
     * @param categoryDTO
     * @return :
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类:{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();

    }
    /**
     * 功能描述: 启用禁用分类
     * @param status
     * @param id
     * @return :
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result enableOrDisable(@PathVariable Integer status,long id){
        categoryService.enableOrDisable(status,id);
        return Result.success();

    }

}
