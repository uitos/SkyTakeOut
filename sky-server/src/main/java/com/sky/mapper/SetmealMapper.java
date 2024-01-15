package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    /**
     * 功能描述: 新增套餐
     * @param setmeal
     */
    @AutoFill(OperationType.INSERT)
    void insert(Setmeal setmeal);

    /**
     * 功能描述: 套餐分页查询
     * @param setmealPageQueryDTO
     * @return com.github.pagehelper.Page<com.sky.vo.SetmealVO>
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 功能描述: 根据id查询套餐
     * @param id
     * @return com.sky.vo.Setmeal
     */
    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);

    /**
     * 功能描述: 更新套餐
     * @param setmeal
     */
    @AutoFill(OperationType.UPDATE)
    void update(Setmeal setmeal);

    /**
     * 功能描述: 根据套餐id集合批量删除套餐表中的数据
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 功能描述: 动态条件查询套餐
     * @param setmeal
     * @return java.util.List<com.sky.entity.Setmeal>
     */
    List<Setmeal> list(Setmeal setmeal);
}
