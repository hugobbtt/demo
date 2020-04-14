package com.example.demo.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.demo.common.api.CommonResult;
import com.example.demo.mbg.model.PmsBrand;
import com.example.demo.service.PmsBrandService;
import com.example.demo.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Hugo
 * @date 2020/4/15
 */
@Api(tags = "RedisController", description = "redis测试")
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation("测试简单缓存")
    @RequestMapping(value = "/simpleTest", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> simpleTest() {
        List<PmsBrand> brandList = pmsBrandService.listBrand(1, 5);
        PmsBrand pmsBrand = brandList.get(0);
        String key = "redis:simple" + pmsBrand.getId();
        redisService.set(key, pmsBrand);
        PmsBrand cacheBrand = (PmsBrand) redisService.get(key);
        return CommonResult.success(cacheBrand);
    }

    @ApiOperation("测试hash结构的缓存")
    @RequestMapping(value = "/hashTest", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> hashTest() {
        List<PmsBrand> brandList = pmsBrandService.listBrand(1, 5);
        PmsBrand pmsBrand = brandList.get(0);
        String key = "redis:hash" + pmsBrand.getId();
        Map<String, Object> value = BeanUtil.beanToMap(pmsBrand);
        redisService.hSetAll(key, value);
        Map<Object, Object> cacheValue = redisService.hGetAll(key);
        PmsBrand cacheBrand = BeanUtil.mapToBean(cacheValue, PmsBrand.class, true);
        return CommonResult.success(cacheBrand);
    }
}
