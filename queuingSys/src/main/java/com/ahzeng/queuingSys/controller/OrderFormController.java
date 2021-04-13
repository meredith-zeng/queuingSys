package com.ahzeng.queuingSys.controller;

import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.services.OrderFormService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderForm")
public class OrderFormController {
    private OrderFormService orderFormService;

    @Autowired
    public void setOrderFormService(OrderFormService orderFormService){
        this.orderFormService = orderFormService;
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
