package com.cn.elp.dao;

import com.cn.elp.POJO.Report;

public interface ReportDao {

    /**
     * 根据任务号查找报告
     * @param taskNo
     * @return
     */
    Report findReportByTaskNo(String taskNo);
}
