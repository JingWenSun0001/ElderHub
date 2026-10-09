package com.it.elderhub.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OutwardAddDTO {
    private Integer customerId;
    private String outgoingReason;
    private LocalDateTime outgoingTime;
    private LocalDateTime expectedReturnTime;
    private String escorted;
    private String relation;
    private String escortedTel;
    private String remarks;
}