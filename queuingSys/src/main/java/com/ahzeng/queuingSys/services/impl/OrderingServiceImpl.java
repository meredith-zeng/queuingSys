package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.OrderingMapper;
import com.ahzeng.queuingSys.pojo.Ordering;
import com.ahzeng.queuingSys.services.GuestService;
import com.ahzeng.queuingSys.services.OrderFormService;
import com.ahzeng.queuingSys.services.OrderingService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.GuestVo;
import com.ahzeng.queuingSys.vo.OrderFormVo;
import com.ahzeng.queuingSys.vo.OrderingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderingServiceImpl implements OrderingService {
    @Autowired
    OrderingMapper orderingMapper;
    @Autowired
    OrderFormService orderFormService;
    @Autowired
    GuestService guestService;

    /**
     * 需要的字段：
     *  @return
     *     Integer orderCode;
     *     Date orderTime;
     *     String orderStatus;
     *     Integer guestId
     *
     *     String phoneNumber;
     *     String lastName;
     *     String gender;
     **/

    //需要调用orderFormService的内容和GuestService的内容
    @Override
    public Result<List<OrderingVo>> OrderingSelect(Ordering record) {
        List<Ordering> orderingList = orderingMapper.select(record);
        if (orderingList.size() > 0){
            List<OrderingVo> orderingVoList = new LinkedList<>();
            for (int i = 0; i <orderingList.size(); i++){
                OrderingVo orderingVo = new OrderingVo();
                int orderCode = orderingList.get(i).getOrderCode();
                int guestId = orderingList.get(i).getGuestId();
                OrderFormVo orderFormVo = orderFormService.OrderFormSelectByPrimaryKey(orderCode).getData();
                GuestVo guestVo = guestService.GuestSelectByPrimaryKey(guestId).getData();

                    orderingVo.setOrderCode(orderFormVo.getOrderCode());
                    orderingVo.setOrderTime(orderFormVo.getOrderTime());
                    orderingVo.setOrderStatus(orderFormVo.getOrderStatus());

                    orderingVo.setGuestId(orderFormVo.getGuestId());

                    orderingVo.setGender(guestVo.getGender());
                    orderingVo.setPhoneNumber(guestVo.getPhoneNumber());
                    orderingVo.setLastName(guestVo.getLastName());
                orderingVoList.add(i,orderingVo);
            }
            return Result.success(orderingVoList);
        }
        return Result.error(CodeMsg.OrderingSelect_ERROR);
    }

    @Override
    public Result<OrderingVo> OrderingSelectByPrimaryKey(Ordering key) {
        //这里Object key的格式为Ordering
        int orderCode = key.getOrderCode();
        //通过orderCode从orderFormService中取得orderFormVo的信息
        OrderFormVo orderFormVo = orderFormService.OrderFormSelectByPrimaryKey(orderCode).getData();
        //将信息组装如orderingVo中
        if (orderFormVo != null){
            //通过guestId从GuestService中国取得guestVo的信息
            GuestVo guestVo = guestService.GuestSelectByPrimaryKey(orderFormVo.getGuestId()).getData();
            OrderingVo orderingVo = new OrderingVo();
            orderingVo.setOrderCode(orderFormVo.getOrderCode());
            orderingVo.setOrderTime(orderFormVo.getOrderTime());
            orderingVo.setOrderStatus(orderFormVo.getOrderStatus());

            orderingVo.setGuestId(orderFormVo.getGuestId());

            orderingVo.setGender(guestVo.getGender());
            orderingVo.setPhoneNumber(guestVo.getPhoneNumber());
            orderingVo.setLastName(guestVo.getLastName());
            return Result.success(orderingVo);
        }
        return Result.error(CodeMsg.OrderingSelectByPrimaryKey_ERROR);
    }

    @Transactional
    @Override
    public CodeMsg OrderingUpdateByPrimaryKeySelective(Ordering record) {
        int resultOfOperation = orderingMapper.updateByPrimaryKeySelective(record);
        if(resultOfOperation == 1){
            return CodeMsg.OrderingUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.OrderingUpdateByPrimaryKeySelective_ERROR;
    }

    @Transactional
    @Override
    public CodeMsg OrderingInsertSelective(Ordering record) {
        int resultOfOperation = orderingMapper.insertSelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.OrderingInsertSelective_SUCCESS;
        }
        return CodeMsg.OrderingInsertSelective_ERROR;
    }

    @Transactional
    @Override
    public CodeMsg OrderingDeleteByPrimaryKey(Object key) {
        int resultOfOperation = orderingMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.OrderingDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.OrderingDeleteByPrimaryKey_ERROR;
    }
}
