package com.it.elderhub.dto;

import lombok.Data;
import java.time.LocalDate;

/**
 * 客户护理项目购买 DTO
 */
@Data
public class CustomerNurseItemAddDTO {

    private Integer customerId;

    private Integer itemId;

    // 购买/续费的数量
    private Integer addCount;

    // 自定义到期时间 (可选)
    private LocalDate maturityTime;
}