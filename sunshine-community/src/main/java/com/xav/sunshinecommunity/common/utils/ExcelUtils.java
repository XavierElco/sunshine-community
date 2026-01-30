package com.xav.sunshinecommunity.common.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.xav.sunshinecommunity.common.core.exception.BaseException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/19 17:21
 */
public class ExcelUtils {

    private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);
    /**
     * excel 导出
     * @param list          数据类型
     * @param pojoClazz     pojo类型
     * @param fileName      导出的excel名字
     * @param response
     * @param exportParams  导出参数（标题，sheet名称，是否创建表头，表哥， 表格类型）
     */
    public static void exportExcel(List<?> list, Class<?> pojoClazz, String fileName, HttpServletResponse response, ExportParams exportParams){

        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClazz, list);
        downLoadExcel(fileName, response, workbook);
    }


    /**
     * excel 下载
     * @param fileName 文件名
     * @param response
     * @param workbook Excel数据对象
     */
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {

        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;

        try {
            // 设置文件名和下载方式
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (IOException e) {
            log.error("导出Excel异常：{}", e.getMessage() );
            throw new BaseException("500", "导出excel失败，请联系网站管理员！");
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                workbook.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
