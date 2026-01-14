package com.xav.sunshinecommunity.common.core.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xav.sunshinecommunity.common.constant.HttpStatus;
import com.xav.sunshinecommunity.common.core.domain.BaseResponse;
import com.xav.sunshinecommunity.common.core.page.PageDomain;
import com.xav.sunshinecommunity.common.core.page.PageResult;
import com.xav.sunshinecommunity.common.utils.ServletUtils;

import java.util.List;

/**
 * 基础控制器类
 * @author Li,chengming
 * @date 2026/1/12 19:56
 */
public class BaseController {

    /* 当前记录起始索引 */
    public static final String PAGE_NUM = "pageNum";

    /* 当前页面大小 */
    public static final String PAGE_SIZE = "pageNum";

    /**
     * 封装分页数据
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_SIZE));

        return pageDomain;
    }

    /**
     * 封装调用PageHelper的startPage函数
     */
    protected void startPage() {
        PageDomain pageDomain = getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        if(pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
    }

    protected PageResult getData(List<?> list) {
        PageResult pageResult = new PageResult();
        pageResult.setCode(HttpStatus.SUCCESS);
        pageResult.setMsg("分页查询成功");
        pageResult.setRows(list);
        pageResult.setTotal(new PageInfo(list).getTotal());

        return pageResult;
    }


    /**
     * 响应返回结果 （针对增删改）
     * @param rows 受影响的行数
     * @return
     */
    protected BaseResponse toAjax(int rows) {
        return rows > 0 ? BaseResponse.success(rows) : BaseResponse.fail("操作失败");
    }
}

