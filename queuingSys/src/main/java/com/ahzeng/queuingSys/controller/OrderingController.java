package com.ahzeng.queuingSys.controller;

import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.services.OrderingService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.OrderingVo;
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

    @RequestMapping(value = "/orderList")
    public String orderList(HttpSession session){
        return "orderList";
    }

    @PostMapping(value = "/selectOne")
    @ResponseBody
    public  Result<OrderingVo> orderingSelectOne(@RequestBody Ordering record){
        if (orderingService.OrderingSelectByPrimaryKey(record) != null){
            return orderingService.OrderingSelectByPrimaryKey(record);
        }
        return Result.error(CodeMsg.OrderingSelectByPrimaryKey_ERROR);
    }

    @GetMapping(value = "/selectAll")
    @ResponseBody
    public Result<List<OrderingVo>> orderingSelectAll(@RequestParam(defaultValue = "1") int page,
                                                      @RequestParam(defaultValue = "10") int limit){
        if (orderingService.OrderingSelectAll() != null){
            return orderingService.OrderingSelectAll();
        }
        return Result.error(CodeMsg.OrderingSelect_ERROR);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public CodeMsg orderingUpdate(@RequestBody Ordering record) {
        return orderingService.OrderingUpdateByPrimaryKeySelective(record);
    }

    //该方法在前台不会直接调用
    //该方法是实现中间表的新增，中间表新增一定要是orderForm新增时才会用
    //保留API
    @PostMapping(value = "/insert")
    @ResponseBody
    public CodeMsg orderingInsert(@RequestBody Ordering record){
        return orderingService.OrderingInsertSelective(record);
    }
    //该方法在前台不会直接调用
    //该方法是实现中间表的删除，中间表删除一定要是orderForm删除时才会用
    //保留API
    @PostMapping(value = "/delete")
    @ResponseBody
    public CodeMsg orderingDelete(@RequestBody Object key){
        return orderingService.OrderingDeleteByPrimaryKey(key);
    }
}
