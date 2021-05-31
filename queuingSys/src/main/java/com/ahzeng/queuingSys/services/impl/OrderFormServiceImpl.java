package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.OrderFormMapper;
import com.ahzeng.queuingSys.pojo.Guest;
import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.services.GuestService;
import com.ahzeng.queuingSys.services.OrderFormService;
import com.ahzeng.queuingSys.services.OrderingService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
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

    @Autowired
    OrderingService orderingService;

    @Autowired
    GuestService guestService;

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
                orderFormVo.setGuestNumber(orderFormList.get(i).getGuestNumber());
                orderFormVoList.add(i,orderFormVo);
            }
            return Result.success(orderFormVoList);
        }
        return Result.error(CodeMsg.OrderFormSelect_ERROR);
    }

    @Override
    public Result<List<OrderFormVo>> OrderFormSelectAll() {
        List<OrderForm> orderFormList = orderFormMapper.selectAll();
        if (orderFormList.size() > 0){
            List<OrderFormVo> orderFormVoList = new LinkedList<>();
            for (int i = 0; i < orderFormList.size(); i++){
                OrderFormVo orderFormVo = new OrderFormVo();
                orderFormVo.setGuestId(orderFormList.get(i).getGuestId());
                orderFormVo.setOrderCode(orderFormList.get(i).getOrderCode());
                orderFormVo.setOrderTime(orderFormList.get(i).getOrderTime());
                orderFormVo.setOrderStatus(orderFormList.get(i).getOrderStatus());
                orderFormVo.setGuestNumber(orderFormList.get(i).getGuestNumber());
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
            orderFormVo.setGuestNumber(orderForm.getGuestNumber());
            return Result.success(orderFormVo);
        }
        return Result.error(CodeMsg.OrderFormSelectByPrimaryKey_ERROR);
    }

    //根据主键修改指定预定订单的信息
    @Transactional
    @Override
    public CodeMsg OrderFormUpdateByPrimaryKeySelective(OrderForm record) {
        if (orderFormMapper.updateByPrimaryKeySelective(record) == 1){
            Ordering ordering = new Ordering();
            ordering.setOrderCode(record.getOrderCode());
            ordering.setGuestId(record.getGuestId());
            CodeMsg codeMsg = orderingService.OrderingUpdateByPrimaryKeySelective(ordering);
            if (codeMsg.getCode().equals(CodeMsg.OrderingUpdateByPrimaryKeySelective_SUCCESS.getCode())){
                return CodeMsg.OrderFormUpdateByPrimaryKeySelective_SUCCESS;
            }
        }
        return CodeMsg.OrderFormUpdateByPrimaryKeySelective_ERROR;
    }

    //新增预定订单
    @Transactional
    @Override
    public CodeMsg OrderFormInsertSelective(OrderForm record) {
        if (orderFormMapper.insertSelective(record) == 1){
            Ordering orderingOfInsert = new Ordering();
            orderingOfInsert.setOrderCode(record.getOrderCode());
            orderingOfInsert.setGuestId(record.getGuestId());
            CodeMsg codeMsg = orderingService.OrderingInsertSelective(orderingOfInsert);
            if (codeMsg.getCode().equals(CodeMsg.OrderingInsertSelective_SUCCESS.getCode())){
                return CodeMsg.OrderFormInsertSelective_SUCCESS;
            }
        }
        return CodeMsg.OrderFormInsertSelective_ERROR;
    }

    //根据主键删除预定订单
    @Transactional
    @Override
    public CodeMsg OrderFormDeleteByPrimaryKey(Object key) {
        int resultOfOperation = orderFormMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            if (orderingService.OrderingDeleteByPrimaryKey(key) == CodeMsg.OrderingDeleteByPrimaryKey_SUCCESS){
            return CodeMsg.OrderFormDeleteByPrimaryKey_SUCCESS;
            }
        }
        return CodeMsg.OrderFormDeleteByPrimaryKey_ERROR;
    }

    @Transactional
    @Override
    public CodeMsg OrderFormNewOne(OrderFormVo record){

        Guest guest = new Guest();
        guest.setPhoneNumber(record.getPhoneNumber());

        if (guestService.GuestSelect(guest).getData() != null){
            int guestId = guestService.GuestSelect(guest).getData().get(0).getGuestId();
            OrderForm orderForm = new OrderForm();
            orderForm.setOrderStatus("待确认");
            orderForm.setPhoneNumber(record.getPhoneNumber());
            orderForm.setGuestNumber(record.getGuestNumber());
            orderForm.setOrderTime(record.getOrderTime());
            orderForm.setGuestId(guestId);
            if (OrderFormInsertSelective(orderForm) == CodeMsg.OrderFormInsertSelective_SUCCESS){
                return CodeMsg.OrderFormInsertSelective_SUCCESS;
            }
        }
        return CodeMsg.OrderFormInsertSelective_ERROR;
    }
}
