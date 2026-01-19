package com.xav.sunshinecommunity.web.controller.system;

import com.xav.sunshinecommunity.common.core.controller.BaseController;
import com.xav.sunshinecommunity.common.core.domain.BaseResponse;
import com.xav.sunshinecommunity.system.domain.SysDept;
import com.xav.sunshinecommunity.system.service.SysDeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/14 17:15
 */
@RestController
@RequestMapping("/system/dept")
public class sysDeptController extends BaseController {

    @Resource
    SysDeptService deptService;
    
    @GetMapping("/list")
    public BaseResponse findDeptList(SysDept sysDept){
        List<SysDept> sysDepts = deptService.selectDeptList(sysDept);
        return BaseResponse.success(sysDepts);

    }
}
