package com.xav.sunshinecommunity.web.controller.system;

import com.xav.sunshinecommunity.common.core.controller.BaseController;
import com.xav.sunshinecommunity.common.core.domain.BaseResponse;
import com.xav.sunshinecommunity.system.service.SysAreaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Li,chengming
 * @date 2026/1/12 22:12
 */
@RestController
@RequestMapping("/system/area")
public class SysAreaController extends BaseController {

    @Resource
    private SysAreaService sysAreaService;

    @RequestMapping("/tree")
    public BaseResponse getAreaTree() {
        return BaseResponse.success(sysAreaService.findAreaAsTree());
    }
}
