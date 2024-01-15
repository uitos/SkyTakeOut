package com.sky.controller.admin;

import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {

    @Autowired
    DishService dishService;
    /**
     * 功能描述: 新增菜品
     * @param dishDTO
     * @return com.sky.result.Result
     */
    @PostMapping
    @ApiOperation("新增菜品")
    @CacheEvict(cacheNames = "dishCache",key = "#dishDTO.categoryId")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("新增菜品,{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 功能描述: 菜品分页查询
     * @param dishPageQueryDTO
     * @return com.sky.result.Result
     */
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result page(DishPageQueryDTO dishPageQueryDTO){
        log.info("菜品分页查询，{}",dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }
    /**
     * 功能描述: 菜品批量删除
     * @param ids
     * @return com.sky.result.Result
     */
    @DeleteMapping
    @ApiOperation("菜品批量删除")
    @CacheEvict(cacheNames = "dishCache",allEntries = true)
    public Result delete(@RequestParam List<Long> ids){
        log.info("菜品批量删除:{}",ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 功能描述: 根据id查询菜品
     * @param id
     * @return com.sky.result.Result<com.sky.vo.DishVO>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询菜品")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("根据id查询菜品,{}",id);
        DishVO dishVO =  dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }
    /**
     * 功能描述: 起售或停售菜品
     * @param status
     * @param id
     * @return com.sky.result.Result
     */
    @PostMapping("/status/{status}")
    @ApiOperation("起售或停售菜品")
    @CacheEvict(cacheNames = "dishCache",allEntries = true)
    public Result enableOrDisable(@PathVariable Integer status, Long id){
        log.info("起售或停售菜品，{}，{}",status,id);
        dishService.enableOrDisable(status,id);
        return Result.success();
    }
    /**
     * 功能描述:
     * @param dishDTO
     * @return com.sky.result.Result
     */
    @PutMapping
    @ApiOperation("修改菜品")
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("修改菜品,{}",dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }
    /**
     * 根据分类id查询菜品
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<DishVO>> list(Long categoryId) {
        log.info("根据分类查询菜品,{}",categoryId);
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);//查询起售中的菜品

        List<DishVO> list = dishService.listWithFlavor(dish);
        return Result.success(list);

    }
}
