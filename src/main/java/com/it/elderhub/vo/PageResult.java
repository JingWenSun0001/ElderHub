package com.it.elderhub.vo;

import lombok.Data;
import java.util.List;

@Data
public class PageResult<T> {
    private List<T> records; // 当前页的数据列表
    private Long total;      // 总条数
    private Long pageNum;    // 当前页码
    private Long pageSize;   // 每页条数

    // 提供一个构造函数，方便后续转换
    public PageResult(List<T> records, Long total, Long pageNum, Long pageSize) {
        this.records = records;
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}