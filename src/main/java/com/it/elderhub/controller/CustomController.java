package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.entity.Customer;
import com.it.elderhub.service.CustomerService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/customer")
public class CustomController {
    @Autowired
    private CustomerService customerService;

    /**
     * 入住登记
     * POST /admin/customer/save
     */
    @PostMapping("/save")
    public Result<Void> save(@RequestBody Customer customer){
        try {
            customerService.saveCustomer(customer);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    /**
     * 修改客户
     * PUT /update
     */
    @PutMapping("/update")
    public Result<Void> update(@RequestBody Customer customer){
        try {
            customerService.updateCustomer(customer);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除客户
     * DELETE /remocve/{id}
     */
    @DeleteMapping("/remove/{id}")
    public Result<Void> delete(@PathVariable Integer id){
        try {
            customerService.removeCustomer(id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    //老人外出
    @PostMapping("/goOut/{id}")
    public Result<Void> goOut(@PathVariable Integer id){
        customerService.goOut(id);
        return Result.success(null);
    }

    //老人回院
    @PostMapping("/comeback/{id}")
    public Result<Void> comeback(@PathVariable Integer id){
        customerService.comeback(id);
        return Result.success(null);
    }

    /**
     * 无管家客户列表
     * 对应文档：GET /no-nurse
     */
    @GetMapping("/no-nurse")
    public Result<List<Customer>> listNoNurse() {
        List<Customer> list = customerService.listNoNurse();
        return Result.success(list);
    }

}
