package com.it.elderhub.dto;

import lombok.Data;

@Data
public class OutwardQuery {
    private String customerName;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}