package com.example.demo.nosql.mongodb.repository;

import com.example.demo.nosql.mongodb.document.MemberBrowseHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员浏览商品历史记录Repository
 */
public interface MemberBrowseHistoryRepository extends MongoRepository<MemberBrowseHistory, String> {
    /**
     * 根据会员id按照时间倒序获取浏览记录
     * @param memberId
     * @return
     */
    List<MemberBrowseHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);

}
