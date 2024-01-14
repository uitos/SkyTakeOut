package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/setmeal")

@Slf4j
@Api(tags = "套餐相关接口")
public class SetmealController {

    @Autowired
    SetmealService setmealService;

    /**
     * 功能描述: 新增套餐
     * @param setmealDTO
     * @return com.sky.result.Result
     */
    @PostMapping
    @ApiOperation("新增套餐")
    public Result save(@RequestBody SetmealDTO setmealDTO){
        log.info("新增套餐,{}",setmealDTO);
        setmealService.saveWithDish(setmealDTO);
        return Result.success();
    }
    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result page(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("套餐分页查询,{}",setmealPageQueryDTO);
        PageResult pageResult = setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result getById(@PathVariable Long id){
        log.info("根据id查询套餐,{}",id);
        SetmealVO setmealVO = setmealService.getByIdWithDish(id);
        return Result.success(setmealVO);
    }
    @PutMapping
    @ApiOperation("修改套餐")
    public Result update(@RequestBody SetmealDTO setmealDTO){
        log.info("修改套餐，{}",setmealDTO);
        setmealService.update(setmealDTO);
        return Result.success();
    }
    /**
     * 功能描述: 启用禁用套餐
     * @param status
     * @param id
     * @return com.sky.result.Result
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用套餐")
    public Result enableOrDisable(@PathVariable Integer status,long id){
        log.info("启用禁用套餐,{},{}",status,id);
        setmealService.enableOrDisable(status,id);
        return Result.success();
    }
}
