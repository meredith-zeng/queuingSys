package com.ahzeng.queuingSys.controller;

import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.services.OrderFormService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.OrderFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.PostRemove;
import java.util.List;

@Controller
@RequestMapping("/orderForm")
public class OrderFormController {
    private OrderFormService orderFormService;
/**
 * 已经实现的业务方法：
 * 1. /orderForm/selectAll
 * 2. /orderForm/select
 * 3. /orderForm/selectByPrimaryKey
 * 4. /orderForm/insertSelective
 * 5. /orderForm/update
 * 6. /orderForm/delete
 */

    @Autowired
    public void setOrderFormService(OrderFormService orderFormService){
        this.orderFormService = orderFormService;
    }

    @PostMapping(value = "/selectAll")
    @ResponseBody
    public Result<List<OrderFormVo>> orderFormSelectAll() {
        return orderFormService.OrderFormSelectAll();
    }

    @PostMapping(value = "/select")
    @ResponseBody
    public Result<List<OrderFormVo>> orderFormSelect(OrderForm record) {
        return orderFormService.OrderFormSelect(record);
    }

    @PostMapping(value = "/selectByPrimaryKey")
    @ResponseBody
    public Result<OrderFormVo> OrderFormSelectByPrimaryKey(OrderForm record) {
        return orderFormService.OrderFormSelectByPrimaryKey(record.getOrderCode());
    }

    @PostMapping(value = "/insertSelective")
    @ResponseBody
    public CodeMsg OrderFormInsertSelective(OrderForm record) {
        return orderFormService.OrderFormInsertSelective(record);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public CodeMsg orderFormUpdate(@RequestBody OrderForm orderForm) {
        return orderFormService.OrderFormUpdateByPrimaryKeySelective(orderForm);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public CodeMsg orderFormDelete(@RequestBody OrderForm orderForm){
        return orderFormService.OrderFormDeleteByPrimaryKey(orderForm);
    }
}
