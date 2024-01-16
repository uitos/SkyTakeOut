package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    /**
     * 功能描述: 动态条件查询
     * @param shoppingCart
     * @return java.util.List<com.sky.entity.ShoppingCart>
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 功能描述: 根据id修改数量
     * @param cart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart cart);

    /**
     * 功能描述: 插入购物车数据
     * @param shoppingCart
     */
    @Insert("INSERT INTO shopping_cart (name, image, user_id, dish_id, setmeal_id, dish_flavor, number, amount, create_time)" +
            "values (#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{number},#{amount},#{createTime})")
    void insert(ShoppingCart shoppingCart);
}
