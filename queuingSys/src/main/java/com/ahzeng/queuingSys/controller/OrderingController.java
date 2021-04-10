package com.ahzeng.queuingSys.controller;

import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.services.OrderingService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.OrderingVo;
import com.mysql.cj.log.Log;
import com.mysql.cj.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ordering")
public class OrderingController {
    //怎么写入log
    //报错private static final Log logger = LogFactory.getLog(SupplierController.class);
    private OrderingService orderingService;

    @Autowired
    public void setOrderingController(OrderingService orderingService){
        this.orderingService = orderingService;
    }

//    @RequestMapping(value = "/orderingSelectOne",method = RequestMethod.GET)
//    public String getOrderingSelectOne(HttpSession session){
//        return "/ordering/orderingSelectOne";
//    }


    @PostMapping(value = "/orderingSelectOne")
    @ResponseBody
    public  Result<OrderingVo> orderingSelectOne(@RequestBody Ordering record){
        if (orderingService.OrderingSelectByPrimaryKey(record) != null){
            return orderingService.OrderingSelectByPrimaryKey(record);
        }
        return Result.error(CodeMsg.OrderingSelectByPrimaryKey_ERROR);
    }

    @PostMapping(value = "/orderingSelect")
    @ResponseBody
    public Result<List<OrderingVo>> orderingSelect(@RequestBody Ordering record){
        if (orderingService.OrderingSelect(record) != null){
            return orderingService.OrderingSelect(record);
        }
        return Result.error(CodeMsg.OrderingSelect_ERROR);
    }
}
