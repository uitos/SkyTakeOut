package com.sky.service;

import com.sky.vo.TurnoverReportVO;

import java.time.LocalDate;

public interface ReportService {
    /**
     * 功能描述: 统计指定时间区域内的营业额数据
     * @param begin
     * @param end
     * @return com.sky.vo.TurnoverReportVO
     */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);
}
