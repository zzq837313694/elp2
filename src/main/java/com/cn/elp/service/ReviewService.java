package com.cn.elp.service;

import com.cn.elp.POJO.Review;

public interface ReviewService {

    /**
     * 根据任务编号查找审查信息
     * @param taskNo
     * @return
     */
    Review findReviewByTaskNo(String taskNo);

}
