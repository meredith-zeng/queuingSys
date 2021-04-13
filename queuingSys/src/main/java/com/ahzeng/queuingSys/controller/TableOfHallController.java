package com.ahzeng.queuingSys.controller;

import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.pojo.TableOfHall;
import com.ahzeng.queuingSys.services.OrderingService;

import com.ahzeng.queuingSys.services.TableOfHallService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.OrderingVo;
import com.ahzeng.queuingSys.vo.TableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/table")
public class TableOfHallController {
    private TableOfHallService tableOfHallService;

    @Autowired
    public void setTableOfHallController(TableOfHallService tableOfHallServicee){
        this.tableOfHallService = tableOfHallServicee;
    }

    @RequestMapping(value = "/tableList")
    public String orderList(HttpSession session){
        return "tableList";
    }

    @PostMapping(value = "/selectOne")
    @ResponseBody
    public  Result<TableVo>  tableSelectOne(@RequestBody TableOfHall record){
        return tableOfHallService.tableSelectByPrimaryKey(record.getTableId());
    }

    @GetMapping(value = "/selectAll")
    @ResponseBody
    public Result<List<TableVo>> tableSelectAll(){
        if (tableOfHallService.tableSelectAll() != null){
            return tableOfHallService.tableSelectAll();
        }
        return Result.error(CodeMsg.OrderingSelect_ERROR);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public CodeMsg tableUpdate(@RequestBody TableOfHall record) {
        return tableOfHallService.tableUpdateByPrimaryKeySelective(record);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public CodeMsg tableDelete(@RequestBody TableOfHall record) {
        return tableOfHallService.tableDeleteByPrimaryKey(record);
    }
}
