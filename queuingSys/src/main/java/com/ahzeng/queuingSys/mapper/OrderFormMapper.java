package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.OrderForm;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "OrderFormMapper")
public interface OrderFormMapper extends Mapper<OrderForm> {

}