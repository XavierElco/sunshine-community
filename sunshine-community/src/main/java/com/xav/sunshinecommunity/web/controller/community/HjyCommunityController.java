package com.xav.sunshinecommunity.web.controller.community;

import com.xav.sunshinecommunity.common.core.controller.BaseController;
import com.xav.sunshinecommunity.common.core.domain.BaseResponse;
import com.xav.sunshinecommunity.common.core.page.PageResult;
import com.xav.sunshinecommunity.community.domain.HjyCommunity;
import com.xav.sunshinecommunity.community.domain.dto.HjyCommunityDto;
import com.xav.sunshinecommunity.community.service.HjyCommunityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/9 23:42
 */
@RestController
@RequestMapping("/community")
public class HjyCommunityController  extends BaseController {

    @Resource
    private HjyCommunityService  hjyCommunityService;


    /**
     * 多条件分页查询
     * @param hjyCommunity
     * @return
     */
    @GetMapping("/list")
    public PageResult list(HjyCommunity hjyCommunity) {
        startPage();
        List<HjyCommunityDto> list = hjyCommunityService.queryList(hjyCommunity);

        return getData(list);

    }

    /**
     * 新增小区
     * @param hjyCommunity
     * @return
     */
    @PostMapping
    public BaseResponse add(@RequestBody  HjyCommunity hjyCommunity) {
        return toAjax(hjyCommunityService.insertHjyCommunity(hjyCommunity));
    }

    /**
     * 通过id查询小区
     * @param communityId
     * @return
     */
    @GetMapping("/{communityId}")
    public BaseResponse getInfo(@PathVariable("communityId") Long communityId) {
        return BaseResponse.success(hjyCommunityService.selectHjyCommunityById(communityId));
    }

    /**
     * 修改小区
     * @param hjyCommunity
     * @return
     */
    @PutMapping
    public BaseResponse edit(@RequestBody HjyCommunity hjyCommunity) {
        return toAjax(hjyCommunityService.updateHjyCommunity(hjyCommunity));
    }

    /**
     * 更具id批量删除小区数据
     * @param communityIds
     * @return
     */
    @DeleteMapping("/{communityIds}")
    public BaseResponse delete(@PathVariable Long[] communityIds) {
        return toAjax(hjyCommunityService.deleteHjyCommunity(communityIds));
    }

}
