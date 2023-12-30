package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
    void insert(Category category);

    /**
     * 功能描述: 启用禁用分类
     * @param category
     * @return :
     */
    void update(Category category);

    /**
     * 功能描述: 根据id删除分类
     * @param id
     * @return :
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);
}
