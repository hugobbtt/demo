package com.example.demo.service;

import com.example.demo.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrandDto);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(Integer pageNum, Integer pageSize);

    PmsBrand getBrand(Long id);

}
