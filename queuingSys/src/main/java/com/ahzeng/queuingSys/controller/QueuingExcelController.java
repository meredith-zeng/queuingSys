package com.ahzeng.queuingSys.controller;

import com.ahzeng.queuingSys.pojo.QueuingExcel;
import com.ahzeng.queuingSys.services.QueuingExcelService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.QueuingExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/queuingExcel")
public class QueuingExcelController {
    private QueuingExcelService queuingExcelService;
    /**
     * 已经实现的业务方法：
     */
    @Autowired
    public void setQueuingFormService(QueuingExcelService queuingExcelService){
        this.queuingExcelService = queuingExcelService;
    }

    @RequestMapping(value = "/excelList")
    public String queuingList(){
        return "excelListNumber";
    }

    @RequestMapping(value = "/excelListNumber")
    public String excelListNumber(){
        return "excelListNumber";
    }

    @RequestMapping(value = "/excelListTime")
    public String excelListTime(){
        return "excelListTime";
    }

    @PostMapping(value = "/queuingNumber")
    @ResponseBody
    public Result<QueuingExcelVo> QueuingExcelQueuingNumber(QueuingExcel record) {
        return queuingExcelService.QueuingExcelQueuingNumber(record);
    }

    @PostMapping(value = "/queuingTime")
    @ResponseBody
    public Result<QueuingExcelVo> QueuingExcelQueuingTime(QueuingExcel record) {
        return queuingExcelService.QueuingExcelQueuingTime(record);
    }
    @PostMapping(value = "/update")
    @ResponseBody
    public CodeMsg QueuingExcelUpdateByPrimaryKeySelective(QueuingExcel record){
        return queuingExcelService.QueuingExcelUpdateByPrimaryKeySelective(record);
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public CodeMsg QueuingExcelInsertSelective(QueuingExcel record){
        return queuingExcelService.QueuingExcelInsertSelective(record);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public CodeMsg QueuingExcelDeleteByPrimaryKey(QueuingExcel key){
        return queuingExcelService.QueuingExcelDeleteByPrimaryKey(key);
    }
}
