package com.it.elderhub.vo;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class NurseContentVO {
    private Integer id;
    private String nursingName; // 护理项目名称
    private BigDecimal servicePrice; // 价格
    private String executionCycle; // 执行周期
}