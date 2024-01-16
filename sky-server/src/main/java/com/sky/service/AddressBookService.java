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
}
