package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 功能描述: 新增员工
     * @param employeeDTO
     * @return :
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 功能描述: 员工分页查询
     * @param employeePageQueryDTO
     * @return :
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 功能描述: 启用禁用员工账号
     * @param status
     * @param id
     * @return :
     */
    void enableOrDisable(Integer status, long id);

    /**
     * 功能描述: 根据id查询员工信息
     * @param id
     * @return :
     */
    Employee getById(Long id);

    /**
     * 功能描述: 编辑员工信息
     * @param employeeDTO
     * @return :
     */
    void update(EmployeeDTO employeeDTO);
}
