package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 功能描述: 分页查询
     * @param categoryPageQueryDTO
     * @return :
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 功能描述: 插入数据
     * @param category
     * @return :
     */
    @Insert("insert into category " +
            "(type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "value " +
            "(#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Category category);

    /**
     * 功能描述: 根据主键动态修改分类属性
     * @param category
     * @return :
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);

    /**
     * 功能描述: 根据id删除分类
     * @param id
     * @return :
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
