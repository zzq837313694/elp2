package com.cn.elp.dao;

import com.cn.elp.POJO.Review;

public interface ReviewDao {

    /**
     * 查找消缺任务的审查信息
     * @param taskNo
     * @return
     */
    Review findReviewBytaskNo(String taskNo);
}
