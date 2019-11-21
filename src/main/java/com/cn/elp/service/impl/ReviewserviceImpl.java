package com.cn.elp.service.impl;

import com.cn.elp.POJO.Review;
import com.cn.elp.dao.ReviewDao;
import com.cn.elp.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReviewserviceImpl implements ReviewService {

@Resource
    ReviewDao reviewDao;

    /**
     * 根据任务编号查找审查信息
     *
     * @param taskNo
     * @return
     */
    @Override
    public Review findReviewByTaskNo(String taskNo) {
        return reviewDao.findReviewBytaskNo(taskNo);
    }
}
