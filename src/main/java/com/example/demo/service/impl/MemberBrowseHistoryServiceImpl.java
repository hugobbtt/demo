package com.example.demo.service.impl;

import com.example.demo.nosql.mongodb.document.MemberBrowseHistory;
import com.example.demo.nosql.mongodb.repository.MemberBrowseHistoryRepository;
import com.example.demo.service.MemberBrowseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberBrowseHistoryServiceImpl implements MemberBrowseHistoryService {

    @Autowired
    private MemberBrowseHistoryRepository memberBrowseHistoryRepository;

    @Override
    public int create(MemberBrowseHistory memberBrowseHistory) {
        memberBrowseHistory.setId(null);
        memberBrowseHistory.setCreateTime(new Date());
        memberBrowseHistoryRepository.save(memberBrowseHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberBrowseHistory> deleteList = new ArrayList<>();
        for (String id : ids) {
            MemberBrowseHistory memberBrowseHistory = new MemberBrowseHistory();
            memberBrowseHistory.setId(id);
            deleteList.add(memberBrowseHistory);
        }
        memberBrowseHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public List<MemberBrowseHistory> list(Long memberId) {
        return memberBrowseHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
