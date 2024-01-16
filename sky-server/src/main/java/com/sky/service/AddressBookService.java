package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

public interface AddressBookService {
    /**
     * 功能描述: 新增地址
     * @param addressBook
     */
    void save(AddressBook addressBook);

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
    AddressBook getById(Long id);

    /**
     * 功能描述: 根据id修改地址
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     * 功能描述: 设置默认地址
     * @param addressBook
     */
    void setDefault(AddressBook addressBook);
}
