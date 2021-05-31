package com.ahzeng.queuingSys.controller;

import com.ahzeng.queuingSys.pojo.QueuingForm;
import com.ahzeng.queuingSys.services.QueuingFormService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.QueuingFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/queuingForm")
public class QueuingFormController {
    private QueuingFormService queuingFormService;

    @Autowired
    public void setQueuingFormService(QueuingFormService queuingFormService){
        this.queuingFormService = queuingFormService;
    }

    @RequestMapping(value = "/queuingList")
    public String queuingList(){
        return "queuingList";
    }

    @GetMapping(value = "/selectAll")
    @ResponseBody
    public Result<List<QueuingFormVo>> queuingFormSelectAll(@RequestParam(defaultValue = "1") int page,
                                                            @RequestParam(defaultValue = "10") int limit){
            return queuingFormService.QueuingFormSelectAll();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public CodeMsg queuingFormUpdate(@RequestBody QueuingForm queuingForm){
        return queuingFormService.QueuingFormUpdateByPrimaryKeySelective(queuingForm);
    }

    @PostMapping(value = "/newQueuingForm")
    @ResponseBody
    public Result<QueuingFormVo> newQueuingForm(@RequestBody QueuingFormVo record) throws ParseException {
        return queuingFormService.QueuingFormNewOne(record);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public CodeMsg QueuingFormDeleteByPrimaryKey(@RequestBody QueuingForm record){
        return queuingFormService.QueuingFormDeleteByPrimaryKey(record);
    }

    @PostMapping(value = "/select")
    @ResponseBody
    public Result<List<QueuingFormVo>> QueuingFormSelect(@RequestBody QueuingForm record){
        return queuingFormService.QueuingFormSelect(record);
    }

    @PostMapping(value = "/selectById")
    @ResponseBody
    public Result<QueuingFormVo> QueuingFormSelectById(@RequestBody QueuingForm record){
        return queuingFormService.QueuingFormSelectByPrimaryKey(record.getQueuingOrderId());
    }
}
