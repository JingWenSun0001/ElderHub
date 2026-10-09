package com.it.elderhub.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BackDownAddDTO {
    private Integer customerId;      // 客户ID (必填)
    private LocalDateTime retreatTime; // 退住时间
    private Integer retreatType;     // 退住类型 (0:正常退住, 1:死亡退住, 2:保留床位)
    private String retreatReason;    // 退住原因
    private String remarks;          // 备注
}