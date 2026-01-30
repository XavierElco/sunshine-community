package com.xav.sunshinecommunity.web.controller.common;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.xav.sunshinecommunity.common.core.controller.BaseController;
import com.xav.sunshinecommunity.common.core.domain.BaseResponse;
import com.xav.sunshinecommunity.common.utils.ExcelUtils;
import com.xav.sunshinecommunity.community.domain.HjyCommunity;
import com.xav.sunshinecommunity.community.domain.dto.HjyCommunityDto;
import com.xav.sunshinecommunity.community.domain.dto.HjyCommunityExcelDto;
import com.xav.sunshinecommunity.community.service.HjyCommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Li,chengming
 * @date 2026/1/19 19:03
 */
@RestController
@RequestMapping("/exportExcel")
public class ExportExcelController extends BaseController {

    @Resource
    private HjyCommunityService hjyCommunityService;

    /**
     * 导出小区数据
     * @param hjyCommunity
     * @param response
     * @return
     */
    @GetMapping("/exportCommunityExcel")
    public BaseResponse exportExcel(HjyCommunity hjyCommunity, HttpServletResponse response){

        startPage();
        List<HjyCommunityDto> list = hjyCommunityService.queryList(hjyCommunity);

        // 数据的转换
        List<HjyCommunityExcelDto> excelDtoList = list.stream().map(hjyCommunityDto -> {
            HjyCommunityExcelDto excelDto = new HjyCommunityExcelDto();
            excelDto.setCommunityId(hjyCommunityDto.getCommunityId());
            excelDto.setCommunityName(hjyCommunityDto.getCommunityName());
            excelDto.setCommunityCode(hjyCommunityDto.getCommunityCode());
            excelDto.setCommunityProvinceName(hjyCommunityDto.getCommunityProvinceName());
            excelDto.setCommunityCityName(hjyCommunityDto.getCommunityCityName());
            excelDto.setCommunityTownName(hjyCommunityDto.getCommunityTownName());
            excelDto.setCreateTime(hjyCommunityDto.getCreateTime());
            excelDto.setRemark(hjyCommunityDto.getRemark());
            return excelDto;
        }).collect(Collectors.toList());

        ExcelUtils.exportExcel(excelDtoList, HjyCommunityExcelDto.class, "小区信息", response, new ExportParams("小区列表", "小区信息"));

        return BaseResponse.success("导出小区信息成功");
    }
}
