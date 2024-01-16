package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.result.Result;
import com.sky.service.AddressBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/addressBook")
@Slf4j
@Api(tags = "C端-地址簿接口")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;
    /**
     * 功能描述: 新增地址
     * @param addressBook
     * @return com.sky.result.Result
     */

    @PostMapping
    @ApiOperation("新增地址")
    public Result save(@RequestBody AddressBook addressBook){
        log.info("新增地址为,{}",addressBook);
        addressBookService.save(addressBook);
        return Result.success();
    }

    /**
     * 功能描述: 条件查询
     * @param addressBook
     * @return com.sky.result.Result<com.sky.entity.AddressBook>
     */
    @GetMapping("/list")
    @ApiOperation("条件查询地址")
    public Result<List<AddressBook>> list(AddressBook addressBook){
        log.info("条件查询地址，{}",addressBook);
        List<AddressBook> addressBookList = addressBookService.list(addressBook);
        return Result.success(addressBookList);
    }

    /**
     * 功能描述: 根据id查询地址
     * @param id
     * @return com.sky.result.Result<com.sky.entity.AddressBook>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询地址")
    public Result<AddressBook> getById(@PathVariable Long id){
        log.info("根据id查询地址,{}",id);
        AddressBook addressBook = addressBookService.getById(id);
        return Result.success(addressBook);
    }

    /**
     * 功能描述: 根据id修改地址
     * @param addressBook
     * @return com.sky.result.Result
     */
    @PutMapping
    @ApiOperation("根据id修改地址")
    public Result update(@RequestBody AddressBook addressBook){
        log.info("根据id修改地址,{}",addressBook);
        addressBookService.update(addressBook);
        return Result.success();
    }

    /**
     * 功能描述: 设置默认地址
     * @param addressBook
     * @return com.sky.result.Result
     */
    @PutMapping("/default")
    @ApiOperation("设置默认地址")
    public Result setDefault(@RequestBody AddressBook addressBook){
        log.info("设置默认地址,{}",addressBook);
        addressBookService.setDefault(addressBook);
        return Result.success();
    }

    /**
     * 功能描述:  查询默认地址
     * @return com.sky.result.Result<com.sky.entity.AddressBook>
     */
    @GetMapping("default")
    @ApiOperation("查询默认地址")
    public Result<AddressBook> getDefault() {
        log.info("查询默认地址");
        //SQL:select * from address_book where user_id = ? and is_default = 1
        AddressBook addressBook = new AddressBook();
        addressBook.setIsDefault(1);
        addressBook.setUserId(BaseContext.getCurrentId());
        List<AddressBook> list = addressBookService.list(addressBook);

        if (list != null && list.size() == 1) {
            return Result.success(list.get(0));
        }

        return Result.error("没有查询到默认地址");
    }

    /**
     * 功能描述: 根据id删除地址
     * @param id
     * @return com.sky.result.Result
     */
    @DeleteMapping
    @ApiOperation("根据id删除地址")
    public Result deleteById(Long id) {
        log.info("根据id删除地址,{}",id);
        addressBookService.deleteById(id);
        return Result.success();
    }
}
