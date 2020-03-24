package com.example.demo.service;

import com.example.demo.nosql.mongodb.document.MemberBrowseHistory;

import java.util.List;

public interface MemberBrowseHistoryService {
    int create(MemberBrowseHistory memberBrowseHistory);

    int delete(List<String> ids);

    List<MemberBrowseHistory> list(Long memberId);

}
