package com.it.elderhub.controller;

import com.it.elderhub.common.Result;
import com.it.elderhub.dto.CustomerNurseItemAddDTO;
import com.it.elderhub.service.CustomerNurseItemService;
import com.it.elderhub.vo.CustomerNurseItemVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/customer")
public class CustomerNurseItemController {
    private final CustomerNurseItemService customerNurseItemService;

    public CustomerNurseItemController(CustomerNurseItemService customerNurseItemService) {
        this.customerNurseItemService = customerNurseItemService;
    }

    /**
     * 1.POST/level/set-设置护理级别
     */
    @PostMapping
    public Result<Void> setLevel(@RequestBody Integer customerId,
                                 @RequestParam Integer levelId){
        customerNurseItemService.setCustomerLevel(customerId, levelId);
        return Result.success(null);
    }

    /**
     * 2. DELETE /level/remove/{customerId} - 移除护理级别
     */
    @DeleteMapping("/level/remove/{customerId}")
    public Result<Void> removeLevel(@PathVariable Integer customerId) {
        customerNurseItemService.removeCustomerLevel(customerId);
        return Result.success(null);
    }

    /**
     * 3. GET /nurse-items/{customerId} - 查看客户已购项目 (含状态)
     */
    @GetMapping("/nurse-items/{customerId}")
    public Result<List<CustomerNurseItemVO>> getItems(@PathVariable Integer customerId) {
        return Result.success(customerNurseItemService.listCustomerNurseItems(customerId));
    }

    /**
     * 4. POST /nurse-item/renew - 续费
     */
    @PostMapping("/nurse-item/renew")
    public Result<Void> renew(@RequestParam Integer id, @RequestParam Integer addCount) {
        customerNurseItemService.renewItem(id, addCount);
        return Result.success(null);
    }
    /**
     * 5. DELETE /nurse-item/remove/{id} - 移除客户项目
     */
    @DeleteMapping("/nurse-item/remove/{id}")
    public Result<Void> removeItem(@PathVariable Integer id) {
        customerNurseItemService.removeItem(id);
        return Result.success(null);
    }

    /**
     * 6. POST /nurse-item/buy - 单独购买项目
     */
    @PostMapping("/nurse-item/buy")
    public Result<Void> buyItem(@RequestBody CustomerNurseItemAddDTO dto) {
        customerNurseItemService.buyItem(dto);
        return Result.success(null);
    }

}
