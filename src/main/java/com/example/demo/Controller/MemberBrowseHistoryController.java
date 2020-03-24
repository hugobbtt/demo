package com.example.demo.Controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.nosql.mongodb.document.MemberBrowseHistory;
import com.example.demo.service.MemberBrowseHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "MemberBrowseHistoryController", description = "会员商品浏览记录管理")
@Controller
@RequestMapping("/member/browseHistory")
public class MemberBrowseHistoryController {
    @Autowired
    private MemberBrowseHistoryService memberBrowseHistoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody MemberBrowseHistory memberBrowseHistory) {
        int count = memberBrowseHistoryService.create(memberBrowseHistory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除浏览记录")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<String> ids) {
        int count = memberBrowseHistoryService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("展示用户浏览记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MemberBrowseHistory>> list(Long memberId) {
        List<MemberBrowseHistory> memberBrowseHistoryList = memberBrowseHistoryService.list(memberId);
        return CommonResult.success(memberBrowseHistoryList);
    }
}
