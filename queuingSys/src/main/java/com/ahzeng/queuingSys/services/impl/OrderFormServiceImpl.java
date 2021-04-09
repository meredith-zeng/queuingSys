package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.OrderFormMapper;
import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.services.OrderFormService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.GuestVo;
import com.ahzeng.queuingSys.vo.OrderFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderFormServiceImpl implements OrderFormService {
    @Autowired
    OrderFormMapper orderFormMapper;

    //按条件查询预定订单，不传参就是返回全部内容
    @Override
    public Result<List<OrderFormVo>> OrderFormSelect(OrderForm record) {
        List<OrderForm> orderFormList = orderFormMapper.select(record);
        if (orderFormList.size() > 0){
            List<OrderFormVo> orderFormVoList = new LinkedList<>();
            for (int i = 0; i < orderFormList.size(); i++){
                OrderFormVo orderFormVo = new OrderFormVo();
                orderFormVo.setGuestId(orderFormList.get(i).getGuestId());
                orderFormVo.setOrderCode(orderFormList.get(i).getOrderCode());
                orderFormVo.setOrderTime(orderFormList.get(i).getOrderTime());
                orderFormVo.setOrderStatus(orderFormList.get(i).getOrderStatus());
                orderFormVoList.add(i,orderFormVo);
            }
            return Result.success(orderFormVoList);
        }
        return Result.error(CodeMsg.OrderFormSelect_ERROR);
    }

    //根据id查询预定订单
    @Override
    public Result<OrderFormVo> OrderFormSelectByPrimaryKey(int id) {
        OrderForm orderForm = orderFormMapper.selectByPrimaryKey(id);
        if (orderForm != null){
            OrderFormVo orderFormVo = new OrderFormVo();
            orderFormVo.setGuestId(orderForm.getGuestId());
            orderFormVo.setOrderCode(orderForm.getOrderCode());
            orderFormVo.setOrderTime(orderForm.getOrderTime());
            orderFormVo.setOrderStatus(orderForm.getOrderStatus());
            return Result.success(orderFormVo);
        }
        return Result.error(CodeMsg.OrderFormSelectByPrimaryKey_ERROR);
    }

    //根据主键修改指定预定订单的信息
    @Transactional
    @Override
    public CodeMsg OrderFormUpdateByPrimaryKeySelective(OrderForm record) {
        if (orderFormMapper.updateByPrimaryKeySelective(record) == 1){
            return CodeMsg.OrderFormUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.OrderFormUpdateByPrimaryKeySelective_ERROR;
    }

    //新增预定订单
    @Transactional
    @Override
    public CodeMsg OrderFormInsertSelective(OrderForm record) {
        if (orderFormMapper.insertSelective(record) == 1){
            return CodeMsg.OrderFormInsertSelective_SUCCESS;
        }
        return CodeMsg.OrderFormInsertSelective_ERROR;
    }

    //根据主键删除预定订单
    @Transactional
    @Override
    public CodeMsg OrderFormDeleteByPrimaryKey(Object key) {
        int resultOfOperation = orderFormMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.OrderFormDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.OrderFormDeleteByPrimaryKey_ERROR;
    }
}