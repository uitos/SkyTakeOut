package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressBookMapper {

    /**
     * 功能描述: 新增地址
     * @param addressBook
     */
    @Insert("insert into address_book " +
            "(user_id, consignee, sex, phone, province_code, province_name, city_code, city_name," +
            " district_code, district_name, detail, label, is_default) " +
            "VALUES " +
            "(#{userId}, #{consignee}, #{sex},#{phone},  #{provinceCode}, #{provinceName}, #{cityCode}, #{cityName}," +
            " #{districtCode}, #{districtName}, #{detail}, #{label}, #{isDefault})")
    void insert(AddressBook addressBook);

    /**
     * 功能描述: 条件查询地址
     * @param addressBook
     * @return java.util.List<com.sky.entity.AddressBook>
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 功能描述: 根据id查询地址
     * @param id
     * @return com.sky.entity.AddressBook
     */
    @Select("select * from address_book where id = #{id}")
    AddressBook getById(Long id);

    /**
     * 功能描述: 根据id修改地址
     * @param addressBook
     */
    void update(AddressBook addressBook);
}
