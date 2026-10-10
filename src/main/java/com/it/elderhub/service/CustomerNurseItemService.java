package com.it.elderhub.service;

import com.it.elderhub.dto.CustomerNurseItemAddDTO;
import com.it.elderhub.entity.CustomerNurseItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.elderhub.vo.CustomerNurseItemVO;

import java.util.List;

/**
* @author Ljz
* @description 针对表【customer_nurse_item(客户已购护理条目表)】的数据库操作Service
* @createDate 2026-10-08 09:52:06
*/
public interface CustomerNurseItemService extends IService<CustomerNurseItem> {

    void setCustomerLevel(Integer customerId,Integer levelId);
    void removeCustomerLevel(Integer customerId);
    List<CustomerNurseItemVO> listCustomerNurseItems(Integer customerId);
    void renewItem(Integer id, Integer addCount);
    void removeItem(Integer id);
    void buyItem(CustomerNurseItemAddDTO dto);


}
