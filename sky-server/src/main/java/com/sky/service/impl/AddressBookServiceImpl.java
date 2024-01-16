package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.mapper.AddressBookMapper;
import com.sky.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {



    @Autowired
    private AddressBookMapper addressBookMapper;



    /**
     * 功能描述: 新增地址
     * @param addressBook
     */
    @Override
    public void save(AddressBook addressBook) {
        Long userId = BaseContext.getCurrentId();
        addressBook.setUserId(userId);
        addressBook.setIsDefault(0);
        addressBookMapper.insert(addressBook);
    }

    /**
     * 功能描述: 条件查询地址
     * @param addressBook
     * @return java.util.List<com.sky.entity.AddressBook>
     */
    @Override
    public List<AddressBook> list(AddressBook addressBook) {

        return addressBookMapper.list(addressBook);
    }
}
