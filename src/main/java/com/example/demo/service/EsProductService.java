package com.example.demo.service;

import com.example.demo.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EsProductService {
    int importAll();

    void delete(Long id);

    void delete(List<Long> ids);

    EsProduct create(Long id);

    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

}
